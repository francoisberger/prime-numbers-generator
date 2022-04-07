package com.github.francoisberger.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.github.francoisberger.controller.Status;

/**
 * Integration tests for PrimeNumbersGenerator.
 * 
 * @author Francois
 *
 */
class PrimeNumbersGeneratorIT {

	private PrimeNumbersGenerator classUnderTest;

	/**
	 * Initializes the PrimeNumbersGenerator to test.
	 */
	@BeforeEach
	void init() {
		classUnderTest = new PrimeNumbersGenerator();
	}

	/**
	 * Tests if we're able to start a generator then interrupt it.
	 * 
	 * @throws InterruptedException Exception is thrown if Thread.sleep is
	 *                              interrupted.
	 */
	@Test
	@Timeout(1)
	void primeNumbersGenerator_shouldStartAndStop() throws InterruptedException {
		// GIVEN
		classUnderTest.start();
		// WHEN
		Thread.sleep(500);
		classUnderTest.interrupt();
		// THEN
		assertThat(classUnderTest.getStatus() == Status.STOPPED);
	}

	/**
	 * Tests if we're able to start a generator from a given point then interrupt
	 * it.
	 * 
	 * @throws InterruptedException Exception is thrown if Thread.sleep is
	 *                              interrupted.
	 */
	@Test
	@Timeout(1)
	void primeNumbersGenerator_shouldStartFromGivenNumber() throws InterruptedException {
		// GIVEN
		classUnderTest.start("200");
		// WHEN
		Thread.sleep(500);
		classUnderTest.interrupt();
		// THEN
		assertThat(classUnderTest.getStatus() == Status.STOPPED);
	}

}
