package com.github.francoisberger.view;

import com.github.francoisberger.controller.Controller;

/**
 * A simple console view interracting with the user at terminal level.
 * 
 * @author Francois
 *
 */
public class ConsoleView implements View {

	private Controller controller;

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

}
