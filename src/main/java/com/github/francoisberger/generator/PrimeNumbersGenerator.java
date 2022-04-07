package com.github.francoisberger.generator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.francoisberger.controller.Controller;
import com.github.francoisberger.controller.Status;
import com.github.francoisberger.view.ConsoleView;
import com.github.francoisberger.view.View;

/**
 * This class is the main entry point for prime numbers generation. It extends
 * Thread so that it can be cleanly interrupted.
 * 
 * @author Francois
 *
 */
public class PrimeNumbersGenerator extends Thread {
	private Controller controller;
	private View view;
	private Logger logger = Logger.getLogger(getName());

	/**
	 * Creates a new PrimeNumbersGenerator with basic controller and console view.
	 */
	public PrimeNumbersGenerator() {
		view = new ConsoleView();
		controller = new Controller(view);
	}

	/**
	 * Starts prime numbers generation from given point. The start point is not
	 * checked for primeness.
	 * 
	 * @param startNumber Starting point from prime number generation.
	 */
	public void start(String startNumber) {
		controller.setStartNumber(startNumber);
		super.start();
	}

	/**
	 * Interrupts the thread with a clean close i.e. we will end current prime
	 * number generation and perform save operations (if required).
	 */
	@Override
	public void interrupt() {
		logger.log(Level.INFO, "Prime number generation interrupted! Stopping controller...");
		controller.stop();
		logger.log(Level.INFO, "Controller stopped. Exiting...");
	}

	/**
	 * Runs the prime numbers generation. This basically starts the internal
	 * controller of the app.
	 */
	@Override
	public void run() {
		controller.start();
	}

	/**
	 * Returns the status of the generator which is basically status of internal
	 * controller.
	 * 
	 * @return Status of the generation.
	 */
	public Status getStatus() {
		return controller.getStatus();
	}

	/**
	 * Runs a PrimeNumbersGenerator to generate prime numbers with a basic console
	 * output.
	 * 
	 * @param args Arguments from the command line (currently ignored).
	 */
	public static void main(String[] args) {
		PrimeNumbersGenerator generator = new PrimeNumbersGenerator();
		generator.start();
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); } generator.interrupt();
		 */
	}

}
