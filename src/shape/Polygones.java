package shape;

import java.util.ArrayList;

import point.Point;


public class Polygones extends Shape {

	private final ArrayList<Line> lines;
	private Point center;
	
	public Polygones(ArrayList<Line> lines) {
		this.lines = lines;
		double centerX = 0, centerY = 0;
		for (int i = 0; i < lines.size(); i++) {
			centerX += lines.get(i).getP1().getX();	
			centerY += lines.get(i).getP1().getY();
		}
		centerX /= lines.size();
		centerY /= lines.size();
		this.center = new Point(centerX, centerY);
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		double res = 0;
		for (Line l : this.lines) {
			res += l.perimeter();
		}
		return res;
	}
	
	@Override
	public Shape homothety(Point p, int ratio) {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).homothety(p, ratio));
		}
		return new Polygones(tmpLines);
	}

	@Override
	public Shape translation(Point p) {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).translation(p));
		}
		return new Polygones(tmpLines);
	}

	@Override
	public Shape rotation() {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).rotationFromPoint(this.center));
		}
		return new Polygones(tmpLines);
	}

	@Override
	public Shape centralSymmetry() {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).centralSymmetryFromPoint(this.center));
		}
		return new Polygones(tmpLines);
	}

	@Override
	public Shape axialSymmetry(String axe) {
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).axialSymmetryFromPoint(this.center, axe));
		}
		return new Polygones(tmpLines);
	}
}
