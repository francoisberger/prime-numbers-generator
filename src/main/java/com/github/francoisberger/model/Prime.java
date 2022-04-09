package com.github.francoisberger.model;

/**
 * Class for prime numbers. This class extends PotentialPrime as PrimeNumbers
 * are basically PotentialPrimes with all requirements matched. Please note that
 * all constructors are package private as one should not be able to create a
 * PrimeNumber without using the PrimeNumberFactory.
 * 
 * @author Francois
 *
 */
public class Prime extends PotentialPrime {
	/**
	 * Creates a prime initialized to 0.
	 * 
	 */
	Prime() {
		super();
	}

	/**
	 * Creates a prime from given number.
	 * 
	 * @param number Number used to initialize this PrimeNumber object
	 */
	Prime(Number number) {
		super(number);
	}

	/**
	 * Creates a prime from given number string representation.
	 * 
	 * @param number Number used to initialize this PrimeNumber object
	 */
	Prime(String number) {
		super(number);
	}

	/**
	 * Creates a copy of a potential prime.
	 * 
	 * @param number PrimeNumber to be copied.
	 */
	Prime(Prime number) {
		super(number);
	}

}
