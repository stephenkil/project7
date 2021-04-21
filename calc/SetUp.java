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
		
		final class numListener implements ActionListener {
			int n; //the number of the button pressed
			
			public numListener(int n) { //constructor for numListener
				this.n = n;
			}
			
			public double current() { //calculates and returns the current number on the screen based on the number of the button pressed
				return(internals.current == 0)? internals.current + n : (internals.current*10) + n;
			}
			
			public void actionPerformed(ActionEvent e) {
				double n = current(); //finds the current number
				internals.current = n; //sets the current number
				face.writeToScreen(df.format(n)); //prints the current number
			}
		}
		
		final class PlusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
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
