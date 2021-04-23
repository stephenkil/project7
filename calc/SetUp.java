package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BinaryOperator;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * June 27, 2014
*/
public class SetUp {
	
	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {
		DecimalFormat df = new DecimalFormat("0.#####"); //needed to avoid printing in scientific notation
		Internals internals = new Internals(); //initializes the calculator internals
		
		Map<Character, Operation> operationMap = new HashMap<>(); //map that stores the calculation action based on the operator
		operationMap.put('+', new Addition()); //stores the addition operation
		operationMap.put('-', new Subtraction()); //stores the addition operation
		operationMap.put('*', new Multiplication()); //stores the addition operation
		operationMap.put('/', new Division()); //stores the addition operation
		
		Map<Boolean, NumButton> numCaseMap1 = new HashMap<>(); //map that stores calculation action based on whether the current number is zero or not
		numCaseMap1.put(true, new NumOperatorExists()); //stores the action to be taken if a previous operator exists
		numCaseMap1.put(false, new NumOperatorNotExist()); //stores the action to be taken if a previous operator does not exist
		
		Map<Boolean, NumButton> numCaseMap2 = new HashMap<>(); //map that stores calculation action based on whether the current number is zero or not
		numCaseMap2.put(true, new CurrentEqualsZero()); //stores the action to be taken if the current number is zero
		numCaseMap2.put(false, new CurrentNotZero()); //stores the action to be taken if the current number is not zero
		
		Map<Boolean, PlusButton> plusCaseMap = new HashMap<>(); //map that stores various calculation actions for the plus operator
		plusCaseMap.put(true, new PlusOperatorExists());
		plusCaseMap.put(false, new PlusOperatorNotExist());
		
		final class NumListener implements ActionListener {
			int n; //the number of the button pressed
			
			public NumListener(int n) { //constructor for numListener
				this.n = n;
			}
			
			public void actionPerformed(ActionEvent e) {
				boolean currentEqualsZero = internals.current == 0; //true if the current number is 0
				boolean operatorExists = internals.operation != Character.MIN_VALUE; //stores whether a previous operator exists or not
				
				NumButton action1 = numCaseMap1.get(operatorExists); //retrieves which action to take based on whether a previous operator exists or not
				internals.current = action1.calculate(internals, internals.current); //the current number is calculated from the retrieved course of action
				
				NumButton action2 = numCaseMap2.get(currentEqualsZero); //retrieves which action to take based on whether the current number is 0 or not
				internals.current = action2.calculate(internals, n); //the current number is calculated from the retrieved course of action
				
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
			}
		}
		
		final class PlusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				boolean operatorExists = internals.first != Double.MIN_VALUE; //if true, then a prior operator exists
				PlusButton action = plusCaseMap.get(operatorExists);
				Internals newInternals = action.calculate(internals.operation, internals);
				internals.current = newInternals.current;
				internals.first = newInternals.first;
				internals.second = newInternals.second;
				internals.operation = newInternals.operation;
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
			}
		}
		
		
		face.addNumberActionListener(0, new NumListener(0));
		face.addNumberActionListener(1, new NumListener(1));
		face.addNumberActionListener(2, new NumListener(2));
		face.addNumberActionListener(3, new NumListener(3));
		face.addNumberActionListener(4, new NumListener(4));
		face.addNumberActionListener(5, new NumListener(5));
		face.addNumberActionListener(6, new NumListener(6));
		face.addNumberActionListener(7, new NumListener(7));
		face.addNumberActionListener(8, new NumListener(8));
		face.addNumberActionListener(9, new NumListener(9));
		face.addActionListener('+', new PlusListener());
		
	}
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
