package Test;

import draw.Draw;
import exceptions.LineCreationException;
import exceptions.PointCreationException;
import point.Point;
import shape.Line;
import shape.Shape;

public class Main {

	public static void main(String[] args) throws LineCreationException, PointCreationException {
		
		Point p1 = new Point((Float) null,1);
		Point p2 = new Point(2,3);
		
		Line l1 = new Line(p1,p2);
		
		Point p3 = new Point(4,4);
		Point p4 = new Point(2,2);
		
		Line l2 = new Line(p3,p4);
		
		l1 = l1.translation(p3);
		
		System.out.println(l1);
		
		
	}

}
