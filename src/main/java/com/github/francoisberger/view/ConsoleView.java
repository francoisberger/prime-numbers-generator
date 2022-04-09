package com.github.francoisberger.view;

import java.util.Scanner;

import com.github.francoisberger.controller.Controller;

/**
 * A simple console view interracting with the user at terminal level.
 * 
 * @author Francois
 *
 */
public class ConsoleView implements View {

	private Controller controller;
	private Scanner keyboard = new Scanner(System.in);

	/**
	 * Sets the controller for this view.
	 * 
	 * @param controller The controller to be used.
	 */
	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Prints a message to console.
	 */
	@Override
	public void print(String message) {
		System.out.println(message);
	}

	/**
	 * Prompts the user for datasource of generated results.
	 * 
	 * @param defaultValue Default value that will be used if user does not specify
	 *                     a datasource.
	 */
	@Override
	public void promptForDataSource(String defaultValue) {
		System.out.format("Enter data source (default=%s): ", defaultValue);
		String datasource = keyboard.nextLine();
		controller.setDataSource(datasource.isEmpty() ? defaultValue : datasource);
	}

	/**
	 * Prompts the user to overwrite datasource.
	 * 
	 * @param defaultValue Default value.
	 */
	@Override
	public void promptForOverwrite(boolean defaultValue) {
		System.out.format("Overwrite (default=%s): ", defaultValue ? "Y" : "N");
		String overwrite = keyboard.nextLine();
		if (overwrite.isEmpty() && defaultValue) {
			controller.overwriteDestination();
		} else if (overwrite.equals("Y")) {
			controller.overwriteDestination();
		}
	}

	/**
	 * Prompts the user whether all primes should be batch saved at the very end of
	 * the whole process or if each prime should be saved right after its
	 * computation.
	 * 
	 * @param defaultValue Default value.
	 */
	@Override
	public void promptForBatchSave(boolean defaultValue) {
		System.out.format("Save all primes as a batch at end of process (default=%s): ", defaultValue ? "Y" : "N");
		String batchSave = keyboard.nextLine();
		if (batchSave.isEmpty() && defaultValue) {
			controller.setBatchSave(true);
		} else if (batchSave.equals("Y")) {
			controller.setBatchSave(true);
		} else {
			controller.setBatchSave(false);
		}

	}

}
