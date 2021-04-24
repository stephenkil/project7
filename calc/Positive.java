package calc;

/**
 * Class that stores the course of action to be taken when converting a number to a positive value.
 */

public class Positive implements PM {
	@Override
	public double convert(double n) {
		return Math.abs(n);
	}
}