package Logic;

import java.util.concurrent.Callable;

public class Check implements Callable<String> {

	private double x;
	private double y;
	private int bottomLine;// нижн€€ граница
	private int upperBound;// верхн€€ граница

	public Check() {
		this.x = 0;
		this.y = 0;
	}

	public Check(Point locMin, int down, int up) {
		this.x = locMin.getX();
		this.y = locMin.getY();
		this.bottomLine = down;
		this.upperBound = up;
	}

	@Override
	public String call() throws Exception {
		double f1, f2;
		String result = new String();
		f1 = (3 * x * x) - (7 * x) - 2;
		f2 = (6 * x) - 7;
		if (-0.1 <= f1 - 0 && f1 - 0 <= 0.1 && f2 > 0) {
			result = "(" + Double.toString(x) + ", " + Double.toString(y) + ") is local minimum";
			return result;
		}
		if (-0.1 <= f1 - 0 && f1 - 0 <= 0.1 && f2 < 0) {
			result = "(" + Double.toString(x) + ", " + Double.toString(y) + ") is local maximum";
			return result;
		}
		if (-0.1 <= x - bottomLine && x - bottomLine <= 0.1) {
			result = "(" + Double.toString(x) + ", " + Double.toString(y) + ") is local minimum";
			return result;
		}
		if (-0.1 <= x - upperBound && x - upperBound <= 0.1) {
			result = "(" + Double.toString(x) + ", " + Double.toString(y) + ") is local maximum";
			return result;
		}
		return "Error";
	}
}
