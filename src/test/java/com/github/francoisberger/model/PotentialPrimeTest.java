package com.github.francoisberger.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit tests for PotentialPrime class.
 * 
 * @author Francois
 *
 */
class PotentialPrimeTest {
	@ParameterizedTest(name = "{0} is prime and should be checked as so...")
	@ValueSource(longs = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
			97 })
	void knownPrimes_shouldBePrime(long source) {
		// Arrange
		PotentialPrime potentialPrime;
		// Act
		potentialPrime = new PotentialPrime(source);
		// Assert
		assertTrue(potentialPrime.isPrime());
	}

	@ParameterizedTest(name = "{0} is not prime and should not be checked as so...")
	@ValueSource(longs = { -29, -3, 0, 12, 14, 18, 21, 24, 28, 30, 35, 36, 42, 49, 56, 64, 72, 81, 99, 100, 110, 121 })
	void nonPrimes_shouldNotBePrime(long source) {
		// Arrange
		PotentialPrime potentialPrime;
		// Act
		potentialPrime = new PotentialPrime(source);
		// Assert
		assertFalse(potentialPrime.isPrime());
	}

	@ParameterizedTest(name = "{0} is even and should be checked as so...")
	@ValueSource(longs = { 0, 2, 4, 6, 8, 10, 256, 512, 1024, 2048, 4096, 10232, 54516, 238496, 856329412 })
	void evenNumbers_shouldBeEven(long source) {
		// Arrange
		PotentialPrime evenNumber;
		// Arrange
		evenNumber = new PotentialPrime(source);
		// Assert
		assertTrue(evenNumber.isEven());
	}

	@ParameterizedTest(name = "{0} is odd and should be checked as so...")
	@ValueSource(longs = { 1, 3, 5, 7, 9, 11, 257, 513, 1025, 2049, 4097, 10233, 54517, 238497, 856329413 })
	void oddNumbers_shouldBeOdd(long source) {
		// Arrange
		PotentialPrime oddNumber;
		// Arrange
		oddNumber = new PotentialPrime(source);
		// Assert
		assertTrue(oddNumber.isOdd());
	}

	@ParameterizedTest(name = "{0} is divisible by 2 and should be checked as so...")
	@ValueSource(longs = { 0, 2, 4, 6, 8, 10, 256, 512, 1024, 2048, 4096, 10232, 54516, 238496, 856329412 })
	void divisibleBy2Numbers_shouldBeDivisibleBy2(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy2());
	}

	@ParameterizedTest(name = "{0} is divisible by 3 and should be checked as so...")
	@ValueSource(longs = { 0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 3 * 256, 3 * 512, 3 * 1024, 3 * 2048, 3 * 4096 })
	void divisibleBy3Numbers_shouldBeDivisibleBy3(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy3());
	}

	@ParameterizedTest(name = "{0} is divisible by 4 and should be checked as so...")
	@ValueSource(longs = { 0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 4 * 256, 4 * 512, 4 * 1024, 4 * 2048,
			4 * 4096 })
	void divisibleBy4Numbers_shouldBeDivisibleBy4(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy4());
	}

	@ParameterizedTest(name = "{0} is divisible by 5 and should be checked as so...")
	@ValueSource(longs = { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 5 * 256, 5 * 512, 5 * 1024, 5 * 2048,
			5 * 4096 })
	void divisibleBy5Numbers_shouldBeDivisibleBy5(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy5());
	}

	@ParameterizedTest(name = "{0} is divisible by 6 and should be checked as so...")
	@ValueSource(longs = { 0, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 6 * 256, 6 * 512, 6 * 1024, 6 * 2048,
			6 * 4096 })
	void divisibleBy6Numbers_shouldBeDivisibleBy6(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy6());
	}

	@ParameterizedTest(name = "{0} is divisible by 7 and should be checked as so...")
	@ValueSource(longs = { 0, 7, 14, 21, 28, 35, 42, 49, 56, 64, 70, 77, 7 * 256, 7 * 512, 7 * 1024, 7 * 2048,
			7 * 4096 })
	void divisibleBy7Numbers_shouldBeDivisibleBy7(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy7());
	}

	@ParameterizedTest(name = "{0} is divisible by 8 and should be checked as so...")
	@ValueSource(longs = { 0, 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 8 * 256, 8 * 512, 8 * 1024, 8 * 2048,
			8 * 4096 })
	void divisibleBy8Numbers_shouldBeDivisibleBy8(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy8());
	}

	@ParameterizedTest(name = "{0} is divisible by 9 and should be checked as so...")
	@ValueSource(longs = { 0, 9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 9 * 256, 9 * 512, 9 * 1024, 9 * 2048,
			9 * 4096 })
	void divisibleBy9Numbers_shouldBeDivisibleBy9(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy9());
	}

	@ParameterizedTest(name = "{0} is divisible by 10 and should be checked as so...")
	@ValueSource(longs = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10 * 256, 10 * 512, 10 * 1024, 10 * 2048,
			10 * 4096 })
	void divisibleBy10Numbers_shouldBeDivisibleBy10(long source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy10());
	}
}
