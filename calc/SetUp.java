package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;

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
		operationMap.put(Character.MIN_VALUE, new NoOperator()); //does nothing when no stored operator exists
		
		Map<Boolean, NumButton> startNew = new HashMap<>(); //map that stores whether to start a new number input or not, depending on internals.startNew
		startNew.put(true, new NumOperatorExists()); //stores the action to be taken if a previous operator exists
		startNew.put(false, new NumOperatorNotExist()); //stores the action to be taken if a previous operator does not exist
		
		Map<Boolean, NumButton> zeroOrNot = new HashMap<>(); //map that stores calculation action based on whether the current number is zero or not
		zeroOrNot.put(true, new CurrentEqualsZero()); //stores the action to be taken if the current number is zero
		zeroOrNot.put(false, new CurrentNotZero()); //stores the action to be taken if the current number is not zero
		
		Map<Boolean, NumButton> decimal = new HashMap<>(); //map that stores calculation action to start a new decimal or not, depending on internals.decimal
		decimal.put(true, new Decimal()); //stores the action to be taken if starting a new decimal
		decimal.put(false, new NoDecimal()); //stores the action to be taken if NOT starting a new decimal
		
		Map<Integer, PM> PM = new HashMap<>(); //map that stores whether to convert a number to positive or negative, depending on internals.PM
		PM.put(1, new Positive()); //stores the action to be taken if converting current to a positive value
		PM.put(-1, new Negative()); //stores the action to be taken if converting current to a negative value
		
		Map<Boolean, OperatorButton> plusCaseMap = new HashMap<>(); //map that stores various calculation actions for the plus operator
		plusCaseMap.put(true, new PlusOperatorExists()); //stores the action to be taken if a previous operator exists
		plusCaseMap.put(false, new PlusOperatorNotExist()); //stores the action to be taken if a previous operator does not exist
		
		Map<Boolean, OperatorButton> minusCaseMap = new HashMap<>(); //map that stores various calculation actions for the minus operator
		minusCaseMap.put(true, new MinusOperatorExists()); //stores the action to be taken if a previous operator exists
		minusCaseMap.put(false, new MinusOperatorNotExist()); //stores the action to be taken if a previous operator does not exist
		
		Map<Boolean, OperatorButton> multiplyCaseMap = new HashMap<>(); //map that stores various calculation actions for the multiply operator
		multiplyCaseMap.put(true, new MultiplyOperatorExists()); //stores the action to be taken if a previous operator exists
		multiplyCaseMap.put(false, new MultiplyOperatorNotExist()); //stores the action to be taken if a previous operator does not exist
		
		Map<Boolean, OperatorButton> divideCaseMap = new HashMap<>(); //map that stores various calculation actions for the divide operator
		divideCaseMap.put(true, new DivideOperatorExists()); //stores the action to be taken if a previous operator exists
		divideCaseMap.put(false, new DivideOperatorNotExist()); //stores the action to be taken if a previous operator does not exist
		
		final class NumListener implements ActionListener {
			int n; //the number of the button pressed
			
			public NumListener(int n) { //constructor for numListener
				this.n = n;
			}
			
			public void actionPerformed(ActionEvent e) {
				PM action1 = PM.get(internals.PM); //retrieves whether to make the current value positive or negative
				
				n = (int) action1.convert(n); //converts n to positive or negative depending on internals.PM
				
				boolean currentEqualsZero = internals.current == 0; //true if the current number is 0
			
				NumButton action2 = zeroOrNot.get(currentEqualsZero); //retrieves which action to take based on whether the current number is 0 or not
				internals.current = action2.calculate(internals, n); //the current number is calculated from the retrieved course of action			
				
				NumButton action3 = startNew.get(internals.startNew); //retrieves whether to start a new number input or continue the current input
				internals.current = action3.calculate(internals, n); //if startNew = true, sets n (the clicked number) to current, effectively starting a new number. Otherwise, does not alter the current value.
				internals.startNew = false; //resets startNew
				
				NumButton action4 = decimal.get(internals.decimal); //retrieves whether to start a new decimal point or not
				internals.current = action4.calculate(internals, n); //applies the corresponding action
				
				internals.current = action1.convert(internals.current); //converts the current value to positive or negative depending on internals.PM
				
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
			}
		}
		
		final class PlusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				boolean operatorExists = internals.operation != Character.MIN_VALUE; //if true, then a prior operator exists
				OperatorButton action = plusCaseMap.get(operatorExists); //retrieves which action to take based on whether a previous operator exists or not
				Internals newInternals = action.calculate(internals.operation, internals); //the newly updated internals are stored
				internals.current = newInternals.current; //and then transferred over to the main internals . . .
				internals.first = newInternals.first; //one . . .
				internals.second = newInternals.second; //by . . .
				internals.operation = newInternals.operation; //one.
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
				internals.current = 0; //resets current
				internals.decimal = false; //resets decimal
				internals.decimalString = ""; //resets decimalString
				internals.PM = 1; //resets PM
			}
		}
		
		final class MinusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				boolean operatorExists = internals.first != Double.MIN_VALUE; //if true, then a prior operator exists
				OperatorButton action = minusCaseMap.get(operatorExists); //retrieves which action to take based on whether a previous operator exists or not
				Internals newInternals = action.calculate(internals.operation, internals); //the newly updated internals are stored
				internals.current = newInternals.current; //and then transferred over to the main internals . . .
				internals.first = newInternals.first; //one . . .
				internals.second = newInternals.second; //by . . .
				internals.operation = newInternals.operation; //one.
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
				internals.current = 0; //resets current
				internals.decimal = false; //resets decimal
				internals.decimalString = ""; //resets decimalString
				internals.PM = 1; //resets PM
			}
		}
		
		final class MultiplyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				boolean operatorExists = internals.first != Double.MIN_VALUE; //if true, then a prior operator exists
				OperatorButton action = multiplyCaseMap.get(operatorExists); //retrieves which action to take based on whether a previous operator exists or not
				Internals newInternals = action.calculate(internals.operation, internals); //the newly updated internals are stored
				internals.current = newInternals.current; //and then transferred over to the main internals . . .
				internals.first = newInternals.first; //one . . .
				internals.second = newInternals.second; //by . . .
				internals.operation = newInternals.operation; //one.
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
				internals.current = 0; //resets current
				internals.decimal = false; //resets decimal
				internals.decimalString = ""; //resets decimalString
				internals.PM = 1; //resets PM
			}
		}
		
		final class DivideListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				boolean operatorExists = internals.first != Double.MIN_VALUE; //if true, then a prior operator exists
				OperatorButton action = divideCaseMap.get(operatorExists); //retrieves which action to take based on whether a previous operator exists or not
				Internals newInternals = action.calculate(internals.operation, internals); //the newly updated internals are stored
				internals.current = newInternals.current; //and then transferred over to the main internals . . .
				internals.first = newInternals.first; //one . . .
				internals.second = newInternals.second; //by . . .
				internals.operation = newInternals.operation; //one.
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
				internals.current = 0; //resets current
				internals.decimal = false; //resets decimal
				internals.decimalString = ""; //resets decimalString
				internals.PM = 1; //resets PM
			}
		}
		
		final class EqualsListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Operation op = operationMap.get(internals.operation); //retrieves which action to take based on the stored operator
				internals.current = op.calculate(internals.first, internals.current); //calculates and stores the current value
				internals.first = Double.MIN_VALUE; //resets the first operand
				internals.operation = Character.MIN_VALUE; //clears the stored/previous operator
				internals.startNew = true; //the next input will start a new number (e.g., 2 + 8 = 12 * 3 would return 36, instead of 3036)
				face.writeToScreen(df.format(internals.current)); //prints the calculated value
				internals.decimal = false; //resets decimal
				internals.decimalString = ""; //resets decimalString
				internals.PM = 1; //resets PM
			}
		}
		
		final class ClearListener implements ActionListener {
			public void actionPerformed(ActionEvent e) { //resets all internal values
				internals.current = 0;
				internals.first = Double.MIN_VALUE;
				internals.second = Double.MIN_VALUE;
				internals.operation = Character.MIN_VALUE;
				internals.startNew = false;
				internals.decimal = false; //resets decimal
				internals.decimalString = ""; //resets decimalString
				face.writeToScreen(""); //resets the display
				internals.PM = 1; //resets PM
			}
		}
		
		final class DecimalListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				internals.decimal = true;
			}
		}
		
		final class PlusMinusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				internals.PM = internals.PM*(-1); //sets internals.PM to the opposite of whatever it currently is
				PM action = PM.get(internals.PM); //retrieves which action to take based on whether internals.PM is + or -
				internals.current = action.convert(internals.current); //calculates and stores the current value accordingly
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
		face.addActionListener('-', new MinusListener());
		face.addActionListener('*', new MultiplyListener());
		face.addActionListener('/', new DivideListener());
		face.addActionListener('=', new EqualsListener());
		face.addActionListener('C', new ClearListener());
		face.addActionListener('.', new DecimalListener());
		face.addPlusMinusActionListener(new PlusMinusListener());
		
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
