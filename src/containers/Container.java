package containers;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import point.Point;
import shape.Line;

public interface Container {
	public Container homothety(Point p, int ratio) throws EllipseCreationException, LineCreationException;
	public Container translation(Point p) throws EllipseCreationException, LineCreationException;
	public Container rotation(int angle) throws EllipseCreationException, LineCreationException;
	public Container centralSymmetry(Point p) throws EllipseCreationException, LineCreationException;
	public Container axialSymmetry(Line l) throws EllipseCreationException, LineCreationException;
	public double area();
	public double perimeter();
}
