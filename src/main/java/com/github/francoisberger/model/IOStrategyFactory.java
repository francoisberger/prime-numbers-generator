package com.github.francoisberger.model;

/**
 * Factory used to generate correct implementation of desired IOStrategy.
 * 
 * @author Francois
 *
 */
public class IOStrategyFactory {

	/**
	 * Returns the proper IOStrategy implementation based on content of the path
	 * string.
	 * 
	 * @param path String representing path to IO (a file path, a jdbc connection
	 *             string, etc.)
	 * @return Desired IOStrategy implementation.
	 */
	public static IOStrategy getStrategy(String path) {
		// TODO analyze path and switch to propose various strategies
		if (!path.endsWith(".txt")) {
			throw new IllegalArgumentException("Unknown IO path: " + path);
		}
		return new TextFileStrategy(path);
	}

}
