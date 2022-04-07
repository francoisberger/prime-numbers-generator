package com.github.francoisberger.model;

import java.math.BigInteger;

/**
 * Generates prime numbers.
 * 
 * @author Francois
 *
 */
public class PrimeNumberFactory {
	private String lastPrime = "";

	/**
	 * Creates a factory that will start at 0 its prime number generation.
	 */
	public PrimeNumberFactory() {

	}

	/**
	 * Creates a factory that will start prime number generation at given parameter.
	 * 
	 * @param startNumber The number to start from.
	 */
	public PrimeNumberFactory(String startNumber) {
		lastPrime = new PotentialPrime(startNumber).toString();
	}

	/**
	 * Computes value of nextPrime.
	 * 
	 * @return Next prime number.
	 */
	public String nextPrime() {
		return nextPrime(lastPrime);
	}

	/**
	 * Computes value of nextPrime starting at given number
	 * 
	 * @param startNumber The number to start from.
	 * @return Next prime number.
	 */
	public String nextPrime(String startNumber) {
		String newPrime = "";
		if (startNumber.isEmpty() || startNumber.equals("0")) {
			newPrime = "2";
		} else if (startNumber.equals("2")) {
			newPrime = "3";
		} else {
			PotentialPrime potentialPrime = new PotentialPrime(startNumber);
			// An even number will not be a prime... we'd better increment by one
			// and move on
			if (potentialPrime.isEven()) {
				potentialPrime = potentialPrime.add(BigInteger.ONE);
			}
			// Test if prime and if not, increment by two (since we're sure to be odd from
			// previous test).
			do {
				potentialPrime = potentialPrime.add(BigInteger.TWO);
			} while (!potentialPrime.isPrime());
			newPrime = potentialPrime.getValue();
		}
		// Store new value for later use
		lastPrime = newPrime;
		return newPrime;

	}

}
