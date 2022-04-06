package com.github.francoisberger.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Integration tests for PrimeNumbersGenerator.
 * 
 * @author Francois
 *
 */
class PrimeNumbersGeneratorIT {

	private PrimeNumbersGenerator classUnderTest;

	@BeforeEach
	void init() {
		classUnderTest = new PrimeNumbersGenerator();
	}

	@Test
	@Timeout(1)
	void primeNumbersGenerator_shouldStartAndStop() throws InterruptedException {
		// GIVEN
		classUnderTest.start();
		// WHEN
		Thread.sleep(500);
		classUnderTest.stop();
		// THEN
		assertThat(classUnderTest.getStatus() == Status.STOPPED);
	}

	@Test
	@Timeout(1)
	void primeNumbersGenerator_shouldStartFromGivenNumber() throws InterruptedException {
		// GIVEN
		classUnderTest.start("200");
		// WHEN
		Thread.sleep(500);
		classUnderTest.stop();
		// THEN
		assertThat(classUnderTest.getStatus() == Status.STOPPED);
	}

}
