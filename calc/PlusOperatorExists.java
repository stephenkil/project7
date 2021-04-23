package calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that stores the course of action to be taken when a previous operator already exists.
 */

public class PlusOperatorExists implements PlusButton {
	public Internals calculate(Character ch, Internals i) {
		Map<Character, Operation> operationMap = new HashMap<>(); //map that stores the calculation action based on the operator
		operationMap.put('+', new Addition()); //stores the addition operation
		operationMap.put('-', new Subtraction()); //stores the addition operation
		operationMap.put('*', new Multiplication()); //stores the addition operation
		operationMap.put('/', new Division()); //stores the addition operation
		
		Operation op = operationMap.get(ch);
		
		i.current = op.calculate(i.first, i.current); //calculates and stores the current value
		i.first = i.current;
		i.second = Double.MIN_VALUE; //reset
		i.operation = '+';
		
		return i;
	}
}
