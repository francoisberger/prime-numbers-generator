package com.github.francoisberger.controller;

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.francoisberger.model.IOStrategy;
import com.github.francoisberger.model.IOStrategyFactory;
import com.github.francoisberger.model.Prime;
import com.github.francoisberger.model.PrimeFactory;
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

	// Members from prime generation
	private PrimeFactory factory;
	private Set<Prime> knownPrimes;

	// Members for data source load and save
	private IOStrategy inAndOut;
	private boolean batchSave = false;

	/**
	 * Creates a new Controller with designed view.
	 * 
	 * @param view The view to be used by this controller.
	 */
	public Controller(View view) {
		this.view = view;
		this.view.setController(this);
		this.factory = new PrimeFactory();
		this.batchSave = false;
		this.knownPrimes = new HashSet<Prime>();
		this.status = Status.STARTING;
	}

	/**
	 * Sets the number from which to start prime number generation
	 * 
	 * @param startNumber The number to start from.
	 */
	public void setStartNumber(String startNumber) {
		this.factory = new PrimeFactory(startNumber);
	}

	/**
	 * Sets the destination where IO operations to save / load will be performed.
	 * 
	 * @param datasource Destination of IO operations.
	 */
	public void setDataSource(String datasource) {
		if (datasource.isEmpty()) {
			throw new IllegalArgumentException("Destination can not be empty!");
		}
		inAndOut = IOStrategyFactory.getStrategy(datasource);
		if (inAndOut.exists()) {
			view.promptForOverwrite(false);
		}

		knownPrimes = inAndOut.load();
		view.print(knownPrimes.size() + " primes found in data source!");
		// Retrieve largest known prime
		if (knownPrimes.size() > 0) {
			String largestPrime = knownPrimes.stream().sorted().sorted(Comparator.reverseOrder())
					.map(number -> number.toString()).collect(Collectors.toList()).get(0);
			view.print("Starting from " + largestPrime + "!");
			factory = new PrimeFactory(largestPrime);
		}
	}

	/**
	 * Sets the batch save flag for data source operations.
	 * 
	 * @param batchSave If true, all generated primes are saved as a batch at the
	 *                  very end of process.
	 */
	public void setBatchSave(boolean batchSave) {
		this.batchSave = batchSave;
	}

	/**
	 * Ensures the data source used for IO operations is cleared.
	 * 
	 */
	public void overwriteDestination() {
		inAndOut.clear();
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
		// We might want to consider System.getProperty("java.io.tmpdir")
		String defaultDataSource = Paths.get("").toAbsolutePath().toString() + FileSystems.getDefault().getSeparator()
				+ "primes.txt";
		view.promptForDataSource(defaultDataSource);
		view.promptForBatchSave(false);
		status = Status.STARTED;
		run();
	}

	/**
	 * Runs the controller i.e. perform prime number generation, display, save and
	 * user interaction if required.
	 */
	private void run() {
		if (status != Status.STARTED) {
			throw new IllegalStateException("Can not run a non started controller!");
		}
		status = Status.RUNNING;

		// Prime generation
		view.print("Generating primes...");
		while (status == Status.RUNNING) {
			Prime prime = factory.nextPrime();
			knownPrimes.add(prime);
			if (!batchSave) {
				inAndOut.save(prime);
			}
		}

		// Saving
		view.print(knownPrimes.size() + " primes found!");
		if (batchSave) {
			view.print("Saving primes...");
			inAndOut.save(knownPrimes);
			view.print("Primes saved!");
		}
		status = Status.STOPPED;
	}

	/**
	 * Stops this controller by setting its internal status to STOPPING
	 */
	public void stop() {
		status = Status.STOPPING;
	}

}
