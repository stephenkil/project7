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
		Internals internals = new Internals();
		Map<Boolean, numButton> caseMap = new HashMap<>(); //map that stores different results to print to the screen for different cases (e.g., is the number 0 or nonzero?)
		caseMap.put(true, new CurrentEqualsZero()); //the current number is zero
		caseMap.put(false, new CurrentNotZero()); //the current number is not zero
		
		final class numListener implements ActionListener {
			int n;
			
			public numListener(int n) { //constructor for numListener
				this.n = n;
			}
			
			public void actionPerformed(ActionEvent e) {
				boolean currentEqualsZero = internals.current == 0;
				numButton action = caseMap.get(currentEqualsZero);
				double toPrint = action.calculate(internals, n);
				internals.current = toPrint;
				face.writeToScreen(df.format(toPrint));
			}
		}
		
		face.addNumberActionListener(0, new numListener(0));
		face.addNumberActionListener(1, new numListener(1));
		face.addNumberActionListener(2, new numListener(2));
		face.addNumberActionListener(3, new numListener(3));
		face.addNumberActionListener(4, new numListener(4));
		face.addNumberActionListener(5, new numListener(5));
		face.addNumberActionListener(6, new numListener(6));
		face.addNumberActionListener(7, new numListener(7));
		face.addNumberActionListener(8, new numListener(8));
		face.addNumberActionListener(9, new numListener(9));
		
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
