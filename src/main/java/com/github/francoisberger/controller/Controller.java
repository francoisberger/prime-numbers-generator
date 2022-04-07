package com.github.francoisberger.controller;

import com.github.francoisberger.model.PrimeNumberFactory;
import com.github.francoisberger.view.View;

/**
 * Class for the controller in the Model / View / Controller design. This will
 * use objects from the data model and call the view for user interaction.
 * 
 * @author Francois
 *
 */
public class Controller {
	private Status status;
	private View view;
	private PrimeNumberFactory factory;

	/**
	 * Creates a new Controller with designed view.
	 * 
	 * @param view The view to be used by this controller.
	 */
	public Controller(View view) {
		this.view = view;
		this.view.setController(this);
		this.factory = new PrimeNumberFactory();
		status = Status.STARTING;
	}

	/**
	 * Sets the number from which to start prime number generation
	 * 
	 * @param startNumber The number to start from.
	 */
	public void setStartNumber(String startNumber) {
		this.factory = new PrimeNumberFactory(startNumber);
	}

	/**
	 * Returns the status of this controller.
	 * 
	 * @return Status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Starts the controller. This is the main entry point for this class.
	 */
	public void start() {
		if (status != Status.STARTING) {
			throw new IllegalStateException("Can not start a non starting controller!");
		}
		status = Status.STARTED;
		run();
	}

	/**
	 * Runs the controller i.e. perform prime number generation, display and user
	 * interaction if required.
	 */
	private void run() {
		if (status != Status.STARTED) {
			throw new IllegalStateException("Can not run a non started controller!");
		}
		status = Status.RUNNING;

		while (status == Status.RUNNING) {
			String prime = factory.nextPrime();
			view.print(prime);
		}

		status = Status.STOPPED;
	}

	/**
	 * Stops this controller by setting its internal status to STOPPING
	 */
	public void stop() {
		if (status != Status.RUNNING) {
			throw new IllegalStateException("Can not stop a non running controller!");
		}
		status = Status.STOPPING;
	}

}
