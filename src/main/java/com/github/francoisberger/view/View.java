package com.github.francoisberger.view;

import com.github.francoisberger.controller.Controller;

/**
 * Interface for views in the Model / View / Controller model.
 * 
 * @author Francois
 *
 */
public interface View {
	/**
	 * Sets the controller for this view.
	 * 
	 * @param controller Controller to be used by this view.
	 */
	public void setController(Controller controller);

	/**
	 * Prints a message (display only).
	 * 
	 * @param message Message to be displayed.
	 */
	public void print(String message);

	/**
	 * Prompts the user for destination where results will be saved. If destination
	 * is not empty, user shall be prompted to continue (i.e. load and continue) /
	 * overwrite previous generation.
	 * 
	 * @param defaultValue Default value.
	 */
	public void promptForDataSource(String defaultValue);

	/**
	 * Prompts the user to overwrite data source.
	 * 
	 * @param defaultValue Default value.
	 */
	public void promptForOverwrite(boolean defaultValue);

	/**
	 * Prompts the user whether all primes should be batch saved at the very end of
	 * the whole process or if each prime should be saved right after its
	 * computation.
	 * 
	 * @param defaultValue Default value.
	 */
	public void promptForBatchSave(boolean defaultValue);
}
