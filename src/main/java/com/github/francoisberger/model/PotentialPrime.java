package com.github.francoisberger.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * A class that allows one to verify if a number is actually a prime number.
 * 
 * @author Francois
 *
 */
public class PotentialPrime {
	private static final String[] KNOWNPRIMES = { "2", "3", "5", "7", "11", "13", "17", "19", "23", "29" };
	private Set<String> knownPrimes = new HashSet<String>(Arrays.asList(KNOWNPRIMES));
	private String value;

	/**
	 * Creates a potential prime from given number.
	 * 
	 * @param number Number used to initialize this PotentialPrime object
	 */
	public PotentialPrime(Number number) {
		value = number.toString();
	}

	/**
	 * Creates a potential prime from given number string representation.
	 * 
	 * @param number Number used to initialize this PotentialPrime object
	 */
	public PotentialPrime(String number) {
		if (number.isEmpty()) {
			value = "0";
		} else {
			value = new BigInteger(number).toString();
		}
	}

	/**
	 * Checks if this number is zero.
	 * 
	 * @return
	 */
	public boolean isZero() {
		return value.equals("0");
	}

	/**
	 * Checks if this number is a prime number.
	 * 
	 * @return true if primer, false otherwise
	 */
	public boolean isPrime() {
		// Check if we are not dealing with a known prime number
		if (knownPrimes.contains(value)) {
			return true;
		}
		// Perform easy checks first
		if (isZero() || isNegative()) {
			return false;
		}
		if (isDivisibleBy2() || isDivisibleBy5() || isDivisibleBy10()) {
			return false;
		}
		if (isDivisibleBy3() || isDivisibleBy6() || isDivisibleBy9()) {
			return false;
		}
		if (isDivisibleBy4() || isDivisibleBy8()) {
			return false;
		}
		if (isDivisibleBy7()) {
			return false;
		}

		// Main loop -> Check if number is divisible by anything but him
		BigInteger valueAsBigInteger = new BigInteger(value);
		BigInteger halfValue = valueAsBigInteger.divide(BigInteger.TWO);
		// Loop from 11 to value / 2 by a two step (i.e. 11 - 13 - 15 - etc.)
		// We do not need to check 12 - 14 - etc. as even numbers are divided by 2
		// and we already performed this check.
		for (BigInteger i = new BigInteger("11"); i.compareTo(halfValue) == -1; i = i.add(BigInteger.TWO)) {
			if (valueAsBigInteger.mod(i).equals(BigInteger.ZERO)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if this number is even.
	 * 
	 * @return true if even, false if odd
	 */
	public boolean isEven() {
		return value.matches(".*[02468]");
	}

	/**
	 * Checks if this number is odd.
	 * 
	 * @return true if odd, false if even
	 */
	public boolean isOdd() {
		return !this.isEven();
	}

	/**
	 * Checks if this number is divisible by 2. Any even number is divisible by 2.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy2() {
		return this.isEven();
	}

	/**
	 * Checks if this number is divisible by 3. To be divisible by 3 the sum of the
	 * digits must be divisible by 3.
	 * 
	 * For example: 417 -> 4 + 1 + 7 = 12 -> 1 + 2 = 3 -> Divisible by 3.
	 * 
	 * Another example: 256 -> 2 + 5 + 6 = 13 -> 1 + 3 = 4 -> Not divisible by 3.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy3() {
		return isDivisibleBy3(value);
	}

	/**
	 * Recursive method to check if a number is divisible by 3. One adds all the
	 * digits of desired number and check if divisible by 3.
	 * 
	 * @param number The number to check.
	 * @return true if divisible by 3, false otherwise.
	 */
	private static boolean isDivisibleBy3(String number) {
		if (number.length() > 1) {
			// Sum the digits
			BigInteger sum = new BigInteger(number.substring(0, 1));
			for (String digit : number.substring(1).split("")) {
				sum = sum.add(new BigInteger(digit));
			}
			return isDivisibleBy3(sum.toString());
		} else if (number.matches("0|3|6|9")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if this number is divisible by 4. Any number with both last digits
	 * divisible by 4 can be divided by 4.
	 * 
	 * For instance: 1020 -> 20 -> Divisible by 4.
	 * 
	 * Another example: 721 -> 21 -> Not divisible by 4.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy4() {
		if (value.length() > 1) {
			String lastTwoDigits = value.substring(value.length() - 2);
			return (Integer.parseInt(lastTwoDigits) % 4 == 0);
		} else if (value.matches("0|4|8")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if this number is divisible by 5. Any number that ends with 0 or 5 is
	 * divisible by 5.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy5() {
		return value.endsWith("0") || value.endsWith("5");
	}

	/**
	 * Checks if this number is divisible by 6. Any number that can be divided by 2
	 * AND divided by 3 is divisible by 6.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy6() {
		return isDivisibleBy2() && isDivisibleBy3();
	}

	/**
	 * Checks if this number is divisible by 7. A number is divisible by 7 if the
	 * difference between the number of tens and the unit number is divisible by 7.
	 * 
	 * For example: 624 -> 62 - 4x2 = 54 -> 54 cannot be divided by 7 -> Not
	 * divisible by 7.
	 * 
	 * Another example: 525 -> 52 - 5x2 = 42 -> 42 can be divided by 7 -> Divisible
	 * by 7.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy7() {
		return isDivisibleBy7(value);
	}

	/**
	 * Recursive method to check if a number is divisible by 7. Split the number to
	 * separate tens and units digits then perform tens - 2 x units and check if
	 * divisible by 7.
	 * 
	 * @param number The number to check.
	 * @return true if divisible by 7, false otherwise.
	 */
	private static boolean isDivisibleBy7(String number) {
		if (number.length() > 1) {
			// Split tens and units
			BigInteger tens = new BigInteger(number.substring(0, number.length() - 1));
			BigInteger units = new BigInteger(number.substring(number.length() - 1));
			BigInteger result = tens.subtract(units.multiply(BigInteger.TWO)).abs();
			return isDivisibleBy7(result.toString());
		} else if (number.matches("0|7")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if this number is divisible by 8. A number is divisible by 8 if the
	 * last 3 digits are divisible by 8.
	 * 
	 * Example: 34152 -> 152 % 8 = 0 -> Divisible by 8.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy8() {
		if (value.length() > 2) {
			// "Long" number, we need to split and check if last three digits
			// are divisible by 8
			String lastThreeDigits = value.substring(value.length() - 3);
			return (Integer.parseInt(lastThreeDigits) % 8 == 0);
		} else {
			// Short number, just check the value
			return (Integer.parseInt(value) % 8 == 0);
		}
	}

	/**
	 * Checks if this number is divisible by 9. The approach is very similar to the
	 * one used to check if a number is divisible by 3. To be divisible by 9 the sum
	 * of the digits must be divisible by 9.
	 * 
	 * For example: 477 -> 4 + 7 + 7 = 18 -> 1 + 8 = 9 -> Divisible by 9.
	 * 
	 * Another example: 1024 -> 1 + 0 + 2 + 4 = 7 -> Not divisible by 9.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy9() {
		return isDivisibleBy9(value);
	}

	/**
	 * Recursive method to check if a number is divisible by 9. One adds all the
	 * digits of desired number and check if divisible by 9.
	 * 
	 * @param number The number to check.
	 * @return true if divisible by 9, false otherwise.
	 */
	private static boolean isDivisibleBy9(String number) {
		if (number.length() > 1) {
			// Sum the digits
			BigInteger sum = new BigInteger(number.substring(0, 1));
			for (String digit : number.substring(1).split("")) {
				sum = sum.add(new BigInteger(digit));
			}
			return isDivisibleBy3(sum.toString());
		} else if (number.matches("0|9")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if this number is divisible by 10. Any number that ends with 0 is
	 * divisible by 10.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy10() {
		return value.endsWith("0");
	}

	/**
	 * Checks if this number is negative.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isNegative() {
		return value.startsWith("-");
	}

}
