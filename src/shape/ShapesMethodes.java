package shape;

import point.Point;

public interface ShapesMethodes {
	
	public Shape homothety(Point p, int ratio);
	public Shape translation(Point p);
	public Shape rotation();
	public Shape centralSymmetry();
	public Shape axialSymmetry(String axe);
	public double area();
	public double perimeter();
	
}
