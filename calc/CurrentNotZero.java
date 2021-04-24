package calc;

/**
 * Class that stores the course of action to be taken when current does not equal zero.
 */

public class CurrentNotZero implements NumButton {
	@Override
	public double calculate(Internals i, double n) {
		//i.current = (i.current*10)+n;
		return (i.current*10)+n;
	}
}