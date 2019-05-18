package Logic;

import java.util.ArrayList;
import java.util.List;

public class FindExtremes {

	private List<Double> row;// double row[];
	private int bottomLine;// нижн€€ граница
	private int upperBound;// верхн€€ граница
	private double step;

	public FindExtremes(int down, int up) {
		this.bottomLine = down;
		this.upperBound = up;
		this.step = 0.01;
		int size = (int) ((upperBound - bottomLine) / step);
		row = new ArrayList<Double>(size);
	}

	public void count() {
		double x = bottomLine;
		for (int i = 0; i <= (upperBound - bottomLine) / step; i++) {
			row.add(i, (x * x * x) - (7 * x * x / 2) - (2 * x) + (3 / 2));															
			x = x + step;
		}
	}

	public Point locMin() {
		Point locMin = new Point(bottomLine, row.get(0));
		double x = bottomLine;
		for (int i = 0; i <= (upperBound - bottomLine) / step; i++) {
			if (row.get(i) < locMin.getY()) {
				locMin.setX(x);
				locMin.setY(row.get(i));
			}
			x = x + step;
		}
		return locMin;
	}

	public Point locMax() {
		Point locMax = new Point(bottomLine, row.get(0));
		double x = bottomLine;
		for (int i = 0; i <= (upperBound - bottomLine) / step; i++) {
			if (row.get(i) > locMax.getY()) {
				locMax.setX(x);
				locMax.setY(row.get(i));
			}
			x = x + step;
		}
		return locMax;
	}
}
