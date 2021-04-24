package calc;

/**
 * Class that stores the course of action to be taken when no prior operator exists.
 */

public class MinusOperatorNotExist implements OperatorButton {
	public Internals calculate(Character ch, Internals i) { //doesn't do anything with the operation character, since no prior operation exists (so ch will be Character.MIN_VALUE)
		i.first = i.current;
		i.operation = '-';
		return i;
	}
}
