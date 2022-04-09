package com.github.francoisberger.model;

import java.math.BigInteger;

/**
 * Generates prime numbers.
 * 
 * @author Francois
 *
 */
public class PrimeFactory {
	private Prime lastPrime = new Prime(0);

	/**
	 * Creates a factory that will start at 0 its prime number generation.
	 */
	public PrimeFactory() {

	}

	/**
	 * Creates a factory that will start prime number generation at given parameter.
	 * 
	 * @param startNumber The number to start from. It may not be a prime as user
	 *                    will fetch the next prime value using nextPrime.
	 */
	public PrimeFactory(String startNumber) {
		lastPrime = new Prime(startNumber);
	}

	/**
	 * Creates a factory that will start prime number generation at given parameter.
	 * 
	 * @param startPrime The number to start from.
	 */
	public PrimeFactory(Prime startPrime) {
		lastPrime = startPrime;
	}

	/**
	 * Computes value of nextPrime.
	 * 
	 * @return Next prime number.
	 */
	public Prime nextPrime() {
		return nextPrime(lastPrime.getValue());
	}

	/**
	 * Computes value of nextPrime starting at given number
	 * 
	 * @param startNumber The number to start from.
	 * @return Next prime number.
	 */
	public Prime nextPrime(String startNumber) {
		Prime newPrime;
		if (startNumber.equals("0")) {
			newPrime = new Prime("2");
		} else if (startNumber.equals("2")) {
			newPrime = new Prime("3");
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
			newPrime = new Prime(potentialPrime.getValue());
		}
		// Store new value for later use
		lastPrime = newPrime;
		return new Prime(newPrime);
	}

}
