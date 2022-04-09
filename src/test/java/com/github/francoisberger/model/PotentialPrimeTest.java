package com.github.francoisberger.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit tests for PotentialPrime class.
 * 
 * @author Francois
 *
 */
class PotentialPrimeTest {
	/**
	 * Ensures an empty string will initialize a PotentialPrime = 0.
	 */
	@Test
	void emptyNumbers_shouldBeTreatedAs0() {
		// Arrange
		PotentialPrime potentialPrime;
		// Act
		potentialPrime = new PotentialPrime("");
		// Assert
		assertThat(potentialPrime.getValue()).isEqualTo("0");
	}

	/**
	 * Tests if negative numbers are considered as negative numbers.
	 * 
	 * @param source Number value.
	 * @param check  Expected value.
	 */
	@ParameterizedTest(name = "{0} is negative and should be considered negative = {1}")
	@CsvSource({ "-121242, true", "-133125, true", "-5, true", "5, false", "102942, false" })
	void knownNumbers_shouldBeNegative(int source, boolean check) {
		// Arrange
		PotentialPrime potentialPrime;
		// Act
		potentialPrime = new PotentialPrime(source);
		// Assert
		assertThat(potentialPrime.isNegative()).isEqualTo(check);
	}

	/**
	 * Tests if known primes are considered as primes.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is prime and should be checked as so...")
	@ValueSource(ints = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
			97 })
	void knownPrimes_shouldBePrime(int source) {
		// Arrange
		PotentialPrime potentialPrime;
		// Act
		potentialPrime = new PotentialPrime(source);
		// Assert
		assertTrue(potentialPrime.isPrime());
	}

	/**
	 * Tests if known non primes are not considered as primes.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is not prime and should not be checked as so...")
	@ValueSource(ints = { -29, -3, 0, 12, 14, 18, 21, 24, 28, 30, 35, 36, 42, 49, 56, 64, 72, 81, 99, 100, 110, 121 })
	void nonPrimes_shouldNotBePrime(int source) {
		// Arrange
		PotentialPrime potentialPrime;
		// Act
		potentialPrime = new PotentialPrime(source);
		// Assert
		assertFalse(potentialPrime.isPrime());
	}

	/**
	 * Tests if even numbers are considered as even.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is even and should be checked as so...")
	@ValueSource(ints = { 0, 2, 4, 6, 8, 10, 256, 512, 1024, 2048, 4096, 10232, 54516, 238496, 856329412 })
	void evenNumbers_shouldBeEven(int source) {
		// Arrange
		PotentialPrime evenNumber;
		// Arrange
		evenNumber = new PotentialPrime(source);
		// Assert
		assertTrue(evenNumber.isEven());
	}

	/**
	 * Tests if odd numbers are considered as odd.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is odd and should be checked as so...")
	@ValueSource(ints = { 1, 3, 5, 7, 9, 11, 257, 513, 1025, 2049, 4097, 10233, 54517, 238497, 856329413 })
	void oddNumbers_shouldBeOdd(int source) {
		// Arrange
		PotentialPrime oddNumber;
		// Arrange
		oddNumber = new PotentialPrime(source);
		// Assert
		assertTrue(oddNumber.isOdd());
	}

	/**
	 * Tests if divisible by 2 numbers are considered as divisible by 2.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 2 and should be checked as so...")
	@ValueSource(ints = { 0, 2, 4, 6, 8, 10, 256, 512, 1024, 2048, 4096, 10232, 54516, 238496, 856329412 })
	void divisibleBy2Numbers_shouldBeDivisibleBy2(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy2());
	}

	/**
	 * Tests if divisible by 3 numbers are considered as divisible by 3.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 3 and should be checked as so...")
	@ValueSource(ints = { 0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 3 * 256, 3 * 512, 3 * 1024, 3 * 2048, 3 * 4096 })
	void divisibleBy3Numbers_shouldBeDivisibleBy3(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy3());
	}

	/**
	 * Tests if divisible by 4 numbers are considered as divisible by 4.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 4 and should be checked as so...")
	@ValueSource(ints = { 0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 4 * 256, 4 * 512, 4 * 1024, 4 * 2048, 4 * 4096 })
	void divisibleBy4Numbers_shouldBeDivisibleBy4(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy4());
	}

	/**
	 * Tests if divisible by 5 numbers are considered as divisible by 5.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 5 and should be checked as so...")
	@ValueSource(ints = { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 5 * 256, 5 * 512, 5 * 1024, 5 * 2048,
			5 * 4096 })
	void divisibleBy5Numbers_shouldBeDivisibleBy5(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy5());
	}

	/**
	 * Tests if divisible by 6 numbers are considered as divisible by 6.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 6 and should be checked as so...")
	@ValueSource(ints = { 0, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 6 * 256, 6 * 512, 6 * 1024, 6 * 2048,
			6 * 4096 })
	void divisibleBy6Numbers_shouldBeDivisibleBy6(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy6());
	}

	/**
	 * Tests if divisible by 7 numbers are considered as divisible by 7.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 7 and should be checked as so...")
	@ValueSource(ints = { 0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 7 * 256, 7 * 512, 7 * 1024, 7 * 2048,
			7 * 4096 })
	void divisibleBy7Numbers_shouldBeDivisibleBy7(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy7());
	}

	/**
	 * Tests if divisible by 8 numbers are considered as divisible by 8.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 8 and should be checked as so...")
	@ValueSource(ints = { 0, 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 8 * 256, 8 * 512, 8 * 1024, 8 * 2048,
			8 * 4096 })
	void divisibleBy8Numbers_shouldBeDivisibleBy8(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy8());
	}

	/**
	 * Tests if divisible by 9 numbers are considered as divisible by 9.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 9 and should be checked as so...")
	@ValueSource(ints = { 0, 9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 9 * 256, 9 * 512, 9 * 1024, 9 * 2048,
			9 * 4096 })
	void divisibleBy9Numbers_shouldBeDivisibleBy9(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy9());
	}

	/**
	 * Tests if divisible by 10 numbers are considered as divisible by 10.
	 * 
	 * @param source Number value.
	 */
	@ParameterizedTest(name = "{0} is divisible by 10 and should be checked as so...")
	@ValueSource(ints = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10 * 256, 10 * 512, 10 * 1024, 10 * 2048,
			10 * 4096 })
	void divisibleBy10Numbers_shouldBeDivisibleBy10(int source) {
		// Arrange
		PotentialPrime number;
		// Arrange
		number = new PotentialPrime(source);
		// Assert
		assertTrue(number.isDivisibleBy10());
	}

	/**
	 * Tests comparison of two potential primes.
	 * 
	 * @param number1 Number 1 value.
	 * @param number2 Number 2 value.
	 */
	@ParameterizedTest(name = "Comparing {0} and {1}")
	@CsvSource({ "-121242, 0", "14, 25", "-5, -10", "3, 42", "209398, 209398", "102942, 10293" })
	void comparingIntegers_shouldMatchIntegerComparison(int number1, int number2) {
		// Arrange
		PotentialPrime potentialPrime1;
		PotentialPrime potentialPrime2;
		// Act
		potentialPrime1 = new PotentialPrime(number1);
		potentialPrime2 = new PotentialPrime(number2);
		// Assert
		assertThat(potentialPrime1.compareTo(potentialPrime2))
				.isEqualTo(Integer.valueOf(number1).compareTo(Integer.valueOf(number2)));
	}

	/**
	 * Ensure numbers are sorted as expected.
	 */
	@Test
	void numbers_shouldSortAsExpected() {
		// Arrange
		List<PotentialPrime> myNumbers = new ArrayList<PotentialPrime>();
		myNumbers.add(new PotentialPrime("123"));
		myNumbers.add(new PotentialPrime("8"));
		myNumbers.add(new PotentialPrime("4"));
		myNumbers.add(new PotentialPrime("145"));
		myNumbers.add(new PotentialPrime("256"));

		// Act
		List<String> sortedList = myNumbers.stream().sorted().map(n -> n.toString()).collect(Collectors.toList());

		// Assert
		assertThat(sortedList.toArray()).isEqualTo(new String[] { "4", "8", "123", "145", "256" });
	}

	/**
	 * Ensure numbers reverse sorted are as expected.
	 */
	@Test
	void numbers_shouldReverseSortAsExpected() {
		// Arrange
		List<PotentialPrime> myNumbers = new ArrayList<PotentialPrime>();
		myNumbers.add(new PotentialPrime("123"));
		myNumbers.add(new PotentialPrime("8"));
		myNumbers.add(new PotentialPrime("4"));
		myNumbers.add(new PotentialPrime("145"));
		myNumbers.add(new PotentialPrime("256"));

		// Act
		List<String> sortedList = myNumbers.stream().sorted().sorted(Comparator.reverseOrder()).map(n -> n.toString())
				.collect(Collectors.toList());

		// Assert
		assertThat(sortedList.toArray()).isEqualTo(new String[] { "256", "145", "123", "8", "4" });
	}
}
