package com.github.francoisberger.controller;

/**
 * Status used by Controller class.
 * 
 * @author Francois
 *
 */
public enum Status {
	/**
	 * Controller is starting.
	 */
	STARTING,
	/**
	 * Controller is started and is able to run.
	 */
	STARTED,
	/**
	 * Controller is running.
	 */
	RUNNING,
	/**
	 * Controller is saving some data.
	 */
	SAVING,
	/**
	 * Controller is stopping and performing final operations.
	 */
	STOPPING,
	/**
	 * Controller is stopped.
	 */
	STOPPED
}