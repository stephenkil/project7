package calc;

/**
 * Class that stores the course of action to be when NOT adding a new decimal point to the current value.
 */

public class NoDecimal implements NumButton {
	@Override
	public double calculate(Internals i, double n) { //does not change anything, since not adding a decimal changes nothing
		return i.current;
	}
}