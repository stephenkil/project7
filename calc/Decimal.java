package calc;

/**
 * Class that stores the course of action to be when adding a new decimal point to the current value.
 */

public class Decimal implements NumButton {
	@Override
	public double calculate(Internals i, double n) {
		i.current = (i.current-n)/10; // undoes CurrentNotZero (to avoid duplicates; e.g., 5 . 6 returns 5.6 instead of 56.6)
		i.decimalString += Integer.toString((int) n);
		
		String currentAsString = Double.toString(i.current);
		int decimalPosition = currentAsString.indexOf('.');
		
		String beforeDecimal = currentAsString.substring(0, decimalPosition);
		//String afterDecimal = currentAsString.substring(decimalPosition+1);
		//int beforeDecimal = Integer.parseInt(currentAsString.substring(0, decimalPosition-1));
		//int afterDecimal = Integer.parseInt(currentAsString.substring(decimalPosition+1));
		
		i.current = Double.parseDouble(beforeDecimal + "." + i.decimalString); //adds n behind the decimal point
		
		return i.current;
	}
}