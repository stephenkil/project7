package calc;


/**
 * Internals
 * 
 * Class that stores the calculator internals.
 *
 * @author Stephen Kil
 * CS 245, Wheaton College
 * April 6, 2021
*/

public class Internals {
	public Internals() {
		this.current = 0;
		this.first = Double.MIN_VALUE;
		this.second = Double.MIN_VALUE;
		this.operation = Character.MIN_VALUE;
	}

	public double current;
	public double first;
	public double second;
	public char operation;
}
