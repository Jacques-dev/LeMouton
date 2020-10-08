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
	public Shape homothety(Point p, int ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape translation(Point p) {
		// TODO Auto-generated method stub
		ArrayList<Line> tmpLines = new ArrayList<Line>();
		for (int i = 0; i < this.lines.size(); i++) {
			tmpLines.add(this.lines.get(i).translation(p));
		}
		return new Polygones(tmpLines);
	}

	@Override
	public Shape rotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape centralSymmetry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape axialSymmetry(String axe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
}
