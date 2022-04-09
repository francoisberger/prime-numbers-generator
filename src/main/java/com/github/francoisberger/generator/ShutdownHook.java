package com.github.francoisberger.generator;

/**
 * Class used to catch the Ctrl-C signal to stop prime numbers generation. The
 * class privacy is package private as it shall not be used outside this
 * package.
 * 
 * @author Francois
 *
 */
class ShutdownHook extends Thread {
	private PrimeNumbersGenerator generator;

	/**
	 * Creates a ShutdownHook that can stop the generator.
	 * 
	 * @param generator The generator to be stopped.
	 */
	ShutdownHook(PrimeNumbersGenerator generator) {
		this.generator = generator;
	}

	/**
	 * Calls the interrupt method on the generator.
	 */
	@Override
	public void run() {
		System.out.println("Shutdown hook: stopping generation...");
		generator.interrupt();
	}
}
