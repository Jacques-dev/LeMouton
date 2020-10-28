package shape;

import exceptions.GeometricalException;
import point.Point;

public interface ShapesMethodes {
	
	public Shape homothety(Point p, int ratio) throws GeometricalException;
	public Shape translation(Point p) throws GeometricalException;
	public Shape rotation(int angle) throws GeometricalException;
	public Shape centralSymmetry(Point p) throws GeometricalException;
	public Shape axialSymmetry(Line l) throws GeometricalException;
	public double area();
	public double perimeter();
	
}
