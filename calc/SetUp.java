package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.math.BigDecimal;

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
		
		DecimalFormat df = new DecimalFormat("0.#####");
		
		final Internals storage = new Internals();
		storage.valueOne = "";
		storage.valueTwo = "";
		storage.operation = "";
		storage.result = "";
		
		
		final class OneListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "1";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="1";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class TwoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "2";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="2";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class ThreeListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "3";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="3";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class FourListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "4";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="4";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class FiveListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "5";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="5";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class SixListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "6";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="6";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class SevenListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "7";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="7";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class EightListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "8";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="8";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class NineListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "9";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="9";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class ZeroListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.result!="") {
					storage.result = "";
					storage.valueOne = "";
					storage.valueTwo = "";
					storage.operation = "";
				}
				
				if(storage.operation=="") {
					storage.valueOne += "0";
					face.writeToScreen(storage.valueOne);
				} else {
					storage.valueTwo +="0";
					face.writeToScreen(storage.valueTwo);
				}
			}
		}
		
		final class PlusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.operation!="") {
					if(storage.operation=="+") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) + Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="-") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) - Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="*") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) * Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="/") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) / Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					}
				}
				
				storage.operation = "+";
				
				if(storage.result!="") {
					storage.valueOne = storage.result;
					storage.valueTwo = "";
					storage.result = "";
				}
			}
		}
		
		final class MinusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.operation!="") {
					if(storage.operation=="+") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) + Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="-") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) - Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="*") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) * Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="/") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) / Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					}
				}
				
				storage.operation = "-";
				
				if(storage.result!="") {
					storage.valueOne = storage.result;
					storage.valueTwo = "";
					storage.result = "";
				}
			}
		}
		
		final class MultiplyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.operation!="") {
					if(storage.operation=="+") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) + Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="-") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) - Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="*") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) * Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="/") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) / Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					}
				}
				
				storage.operation = "*";
				
				if(storage.result!="") {
					storage.valueOne = storage.result;
					storage.valueTwo = "";
					storage.result = "";
				}
			}
		}
		
		final class DivideListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.operation!="") {
					if(storage.operation=="+") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) + Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="-") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) - Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="*") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) * Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					} else if(storage.operation=="/") {
						storage.result = df.format(Double.parseDouble(storage.valueOne) / Double.parseDouble(storage.valueTwo));
						face.writeToScreen(storage.result);
					}
				}
				
				storage.operation = "/";
				
				if(storage.result!="") {
					storage.valueOne = storage.result;
					storage.valueTwo = "";
					storage.result = "";
				}
			}
		}
		
		final class EqualsListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.operation=="") {
					face.writeToScreen(storage.valueOne);
				} else if(storage.operation=="+") {
					storage.result = df.format(Double.parseDouble(storage.valueOne) + Double.parseDouble(storage.valueTwo));
					face.writeToScreen(storage.result);
				} else if(storage.operation=="-") {
					storage.result = df.format(Double.parseDouble(storage.valueOne) - Double.parseDouble(storage.valueTwo));
					face.writeToScreen(storage.result);
				} else if(storage.operation=="*") {
					storage.result = df.format(Double.parseDouble(storage.valueOne) * Double.parseDouble(storage.valueTwo));
					face.writeToScreen(storage.result);
				} else if(storage.operation=="/") {
					storage.result = df.format(Double.parseDouble(storage.valueOne) / Double.parseDouble(storage.valueTwo));
					face.writeToScreen(storage.result);
				}
			}
		}
		
		final class ClearListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				storage.valueOne = "";
				storage.valueTwo = "";
				storage.operation = "";
				storage.result = "";
				face.writeToScreen(storage.result);
			}
		}
		
		final class DecimalListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.valueOne!="" && storage.operation=="") {
					if(storage.valueOne.contains(".")==false) {
						storage.valueOne += ".";
						face.writeToScreen(storage.valueOne);
					}
				} else if(storage.valueOne=="" && storage.operation=="") {
					if(storage.valueOne.contains(".")==false) {
						storage.valueOne += ".";
						face.writeToScreen(storage.valueOne);
					}
				} else {
					if(storage.valueTwo.contains(".")==false) {
						storage.valueTwo +=".";
						face.writeToScreen(storage.valueTwo);
					}
				}
			}
		}
		
		final class PlusMinusListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(storage.valueOne!=""&&storage.valueTwo=="") {
					if(storage.valueOne.contains("-")==false) {
						storage.valueOne = "-" + storage.valueOne;
						face.writeToScreen(storage.valueOne);
					} else {
						storage.valueOne = df.format(Math.abs(Double.parseDouble(storage.valueOne)));
						face.writeToScreen(storage.valueOne);
					}
				} else if(storage.valueTwo!="") {
					if(storage.valueTwo.contains("-")==false) {
						storage.valueTwo = "-" + storage.valueTwo;
						face.writeToScreen(storage.valueTwo);
					} else {
						storage.valueTwo = df.format(Math.abs(Double.parseDouble(storage.valueTwo)));
						face.writeToScreen(storage.valueTwo);
					}
				} else if(storage.result.contains("-")==false) {
					storage.result = "-" + storage.result;
					face.writeToScreen(storage.result);
				} else {
					storage.result = df.format(Math.abs(Double.parseDouble(storage.result)));
					face.writeToScreen(storage.result);
				}
			}
		}
		
		face.addNumberActionListener(1, new OneListener());
		face.addNumberActionListener(2, new TwoListener());
		face.addNumberActionListener(3, new ThreeListener());
		face.addNumberActionListener(4, new FourListener());
		face.addNumberActionListener(5, new FiveListener());
		face.addNumberActionListener(6, new SixListener());
		face.addNumberActionListener(7, new SevenListener());
		face.addNumberActionListener(8, new EightListener());
		face.addNumberActionListener(9, new NineListener());
		face.addNumberActionListener(0, new ZeroListener());
		face.addActionListener('+', new PlusListener());
		face.addActionListener('-', new MinusListener());
		face.addActionListener('*', new MultiplyListener());
		face.addActionListener('/', new DivideListener());
		face.addActionListener('=', new EqualsListener());
		face.addActionListener('C', new ClearListener());
		face.addActionListener('.', new DecimalListener());
		face.addPlusMinusActionListener(new PlusMinusListener());
		
		// add code here that will have the effect of connecting
		// the given face to your calculator
		
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
