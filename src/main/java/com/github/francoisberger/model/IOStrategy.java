package com.github.francoisberger.model;

import java.util.Set;

/**
 * Interface for IO strategy
 * 
 * @author Francois
 *
 */
public interface IOStrategy {

	/**
	 * Checks if data source already exists.
	 * 
	 * @return True if strategy is pointing to an existing data source.
	 */
	boolean exists();

	/**
	 * Clears contents of a data source.
	 */
	void clear();

	/**
	 * Loads contents from a data source.
	 * 
	 * @return List of primes found.
	 */
	Set<Prime> load();

	/**
	 * Saves contents to data source. The data will be appended to data source. It
	 * is the caller's responsibility to clear the data source if required.
	 * 
	 * @param knownPrimes List of primes to be saved.
	 */
	void save(Set<Prime> knownPrimes);

	/**
	 * Saves a prime to data source. The data will be appended to data source. It is
	 * the caller's responsibility to clear the data source if required.
	 * 
	 * @param prime Prime to be saved.
	 */
	void save(Prime prime);

}
