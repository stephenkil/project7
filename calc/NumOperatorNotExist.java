package calc;

/**
 * Class that stores the course of action to be taken when a previous operator does not exist.
 */

public class NumOperatorNotExist implements NumButton {
	@Override
	public double calculate(Internals i, double n) { //does not change anything, since no previous operator exists
		return i.current;
	}
}