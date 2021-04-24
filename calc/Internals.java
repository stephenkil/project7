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
		this.startNew = false;
		this.decimal = false;
		this.decimalString = "";
	}

	public double current;
	public double first;
	public double second;
	public char operation;
	public boolean startNew; //when set to true, starts a new number input
	public boolean decimal; //when set to true, places all subsequent input behind a decimal point
	public String decimalString;
}
