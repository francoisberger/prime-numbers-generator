package com.github.francoisberger.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for PrimeNumberFactory class.
 * 
 * @author Francois
 *
 */
class PrimeFactoryTest {

	/**
	 * Ensures first found prime is 2.
	 */
	@Test
	void firstPrime_shouldBe2() {
		// Arrange
		PrimeFactory factoryUnderTest = new PrimeFactory();
		// Act
		String prime = factoryUnderTest.nextPrime().getValue();
		// Assert
		assertThat(prime).isEqualTo("2");
	}

	/**
	 * Ensures that computing primes starting from a given numbers gives next prime.
	 * 
	 * @param start         Start number for next prime generation.
	 * @param expectedPrime Expected value.
	 */
	@ParameterizedTest(name = "Next prime after {0} should be {1}...")
	@CsvSource({ "0,2", "2,3", "3,5", "5,7", "7,11", "11,13", "13,17", "17,19", "19,23", "23,29", "29,31", "31,37",
			"37,41", "41,43", "43,47", "47,53", "53,59", "59,61", "61,67", "67,71", "71,73", "73,79", "79,83", "83,89",
			"89,97" })
	void nextPrime_shouldBeExpectedPrime(String start, String expectedPrime) {
		// Arrange
		PrimeFactory factoryUnderTest = new PrimeFactory();
		// Act
		String nextPrime = factoryUnderTest.nextPrime(start).getValue();
		// Assert
		assertThat(nextPrime).isEqualTo(expectedPrime);
	}
}
