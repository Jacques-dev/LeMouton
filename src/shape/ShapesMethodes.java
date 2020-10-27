package shape;

import point.Point;

public interface ShapesMethodes {
	
	public Shape homothety(Point p, int ratio);
	public Shape translation(Point p);
	public Shape rotation(int angle);
	public Shape centralSymmetry(Point p);
	public Shape axialSymmetry(Line l);
	public double area();
	public double perimeter();
	
}
