package shape;

import exceptions.GeometricalException;
import exceptions.LineCreationException;
import exceptions.PointCreationException;
import point.Point;

public interface ShapesMethodes {
	
	public Shape homothety(Point p, int ratio) throws GeometricalException, LineCreationException;
	public Shape translation(Point p) throws GeometricalException, LineCreationException;
	public Shape rotation(int angle) throws GeometricalException, LineCreationException;
	public Shape centralSymmetry(Point p) throws GeometricalException, LineCreationException;
	public Shape axialSymmetry(Line l) throws GeometricalException, LineCreationException;
	public double area();
	public double perimeter();
	
}
