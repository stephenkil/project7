package calc;

/**
 * Class that stores the course of action to be taken when current equals zero.
 */

public class CurrentEqualsZero implements NumButton {
	@Override
	public double calculate(Internals i, double n) {
		return n;
	}
}