package shape;

import point.Point;

public class Line extends Shape {
	private final Point p1;
	private final Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public void homothety() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ratation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void centralSymmetry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axialSymmetry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return p1.distance(p2);
	}
	
	
}
