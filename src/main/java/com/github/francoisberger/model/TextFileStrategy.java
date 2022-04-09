package com.github.francoisberger.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the IOStrategy interface to load and save to plain text
 * files.
 * 
 * @author Francois
 *
 */
public class TextFileStrategy implements IOStrategy {
	private File file;

	/**
	 * Creates a TextFileStrategy object pointing to specified file (may or may not
	 * exists).
	 * 
	 * @param filePath Path to desired file.
	 */
	public TextFileStrategy(String filePath) {
		file = new File(filePath);
	}

	/**
	 * Checks if data source already exists.
	 * 
	 * @return True if strategy is pointing to an existing data source.
	 */
	@Override
	public boolean exists() {
		return file.exists();
	}

	/**
	 * Clears contents of a data source.
	 */
	@Override
	public void clear() {
		if (file.exists()) {
			try (FileWriter writer = new FileWriter(file, false)) {
				// try with resources will handle close
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Loads contents from a data source.
	 * 
	 * @return List of primes found.
	 */
	@Override
	public Set<Prime> load() {
		Set<Prime> knownPrimes = new HashSet<Prime>();
		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				knownPrimes = reader.lines().map(Prime::new).collect(Collectors.toCollection(HashSet::new));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return knownPrimes;
	}

	/**
	 * Saves contents to data source. The data will be appended to data source. It
	 * is the caller's responsibility to clear the data source if required.
	 * 
	 * @param knownPrimes List of primes to be saved.
	 */
	@Override
	public void save(Set<Prime> knownPrimes) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			knownPrimes.stream().sorted().forEach(writer::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves a prime to data source. The data will be appended to data source. It is
	 * the caller's responsibility to clear the data source if required.
	 * 
	 * @param prime Prime to be saved.
	 */
	@Override
	public void save(Prime prime) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			writer.println(prime);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
