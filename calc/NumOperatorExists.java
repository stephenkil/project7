package calc;

/**
 * Class that stores the course of action to be taken when a previous operator exists.
 */

public class NumOperatorExists implements NumButton {
	@Override
	public double calculate(Internals i, double n) { //resets n so that a new value can be entered (for example, prevents 2 + 2 resulting in 22; instead, the second 2 would start a new 2)
		return n;
	}
}