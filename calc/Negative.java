package calc;

/**
 * Class that stores the course of action to be taken when converting a number to a negative value.
 */

public class Negative implements PM {
	@Override
	public double convert(double n) {
		return (Math.abs(n)*(-1));
	}
}