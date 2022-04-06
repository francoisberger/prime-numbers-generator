package com.github.francoisberger.model;

/**
 * A class that allows one to verify if a number is actually a prime number.
 * 
 * @author Francois
 *
 */
public class PotentialPrime {

	/**
	 * Creates a potential prime from given number.
	 * 
	 * @param number Number used to initialize this PotentialPrime object
	 */
	public PotentialPrime(Number number) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks if this object is a prime number
	 * 
	 * @return true if primer, false otherwise
	 */
	public boolean isPrime() {
		return false;
	}

	/**
	 * Checks that this object is even.
	 * 
	 * @return true if even, false if odd
	 */
	public boolean isEven() {
		return false;
	}

	/**
	 * Checks that this object is odd.
	 * 
	 * @return true if odd, false if even
	 */
	public boolean isOdd() {
		return !this.isEven();
	}

	/**
	 * Checks that this object is divisible by 2.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy2() {
		return this.isEven();
	}

	/**
	 * Checks that this object is divisible by 3.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy3() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 4.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy4() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 5.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy5() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 6.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy6() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 7.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy7() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 8.
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy8() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 9
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy9() {
		return false;
	}

	/**
	 * Checks that this object is divisible by 10
	 * 
	 * @return true if divisible, false otherwise
	 */
	public boolean isDivisibleBy10() {
		return false;
	}

}
