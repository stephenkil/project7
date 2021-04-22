package calc;

public class CurrentNotZero implements numButton {
	@Override
	public double calculate(Internals i, double n) {
		return (i.current*10)+n;
	}
}