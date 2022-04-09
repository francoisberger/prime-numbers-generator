# prime-numbers-generator
A simple prime numbers generator

General user case and description
----------------------------------------------
As a user, I want to be able to generate prime numbers and save them (to file, database, whatever).

As a user, I want to be able to stop the generation process, and start it again from a certain point (no need to recompute previously generated numbers).

Technical details
----------------------------------------------
The generator uses an MVC architecture. Current view is a simple ConsoleView for user interaction. 

The generator consists of :
- a PotentialPrime class used to check if a number is a prime (containing isPrime, isEven, isDivisibleBy... methods)
- a PrimeFactory that generates primes factory.nextPrime()
- an IOStrategyFactory for data source operations (save and load computed primes). Currently only text file implementation is complete. Access to DB is yet to be implemented.
- some thread related class and hooks so the user can stop the generation process with Ctrl-C with a clean shutdown
