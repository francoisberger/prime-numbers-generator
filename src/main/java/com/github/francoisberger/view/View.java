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
}
