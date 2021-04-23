package calc;

/**
 * SetUp
 * 
 * Strategy pattern for the various different number inputs.
 *
 * @author Stephen Kil
 * CS 245, Wheaton College
 * April 19, 2021
*/

interface Calculation {
	double calculate(double first, double second);
}