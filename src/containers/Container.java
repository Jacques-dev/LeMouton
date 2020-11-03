package containers;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import exceptions.PolygonCreationException;
import point.Point;
import shape.Line;

public interface Container {
	public Container homothety(Point p, int ratio) throws EllipseCreationException, LineCreationException, PolygonCreationException;
	public Container translation(Point p) throws EllipseCreationException, LineCreationException, PolygonCreationException;
	public Container rotation(int angle) throws EllipseCreationException, LineCreationException, PolygonCreationException;
	public Container centralSymmetry(Point p) throws EllipseCreationException, LineCreationException, PolygonCreationException;
	public Container axialSymmetry(Line l) throws EllipseCreationException, LineCreationException, PolygonCreationException;
	public double area();
	public double perimeter();
	public Container copy() throws EllipseCreationException, LineCreationException, PolygonCreationException;
}
