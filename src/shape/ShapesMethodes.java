package shape;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import point.Point;

public interface ShapesMethodes {
	
	public Shape homothety(Point p, int ratio) throws EllipseCreationException, LineCreationException;
	public Shape translation(Point p) throws EllipseCreationException, LineCreationException;
	public Shape rotation(int angle) throws EllipseCreationException, LineCreationException;
	public Shape centralSymmetry(Point p) throws EllipseCreationException, LineCreationException;
	public Shape axialSymmetry(Line l) throws EllipseCreationException, LineCreationException;
	public double area();
	public double perimeter();
	
}
