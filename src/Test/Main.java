package Test;

import java.util.ArrayList;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import point.Point;
import shape.Circle;
import shape.Ellipse;
import shape.Line;
import shape.Polygon;

public class Main {

	public static void main(String[] args) throws LineCreationException, EllipseCreationException{
		
		Point p0 = new Point(1,1);
		Point p1 = new Point(-1,2);
		Point p2 = new Point(8,3);
		Point p3 = new Point(2,3);
		Point p4 = new Point(2,2);
		Point p5 = new Point(6,-2);
		Point p6 = new Point(-2,2);
		Point p7 = new Point(7/2,1/2);
		Point p8 = new Point(4/3,3);
		Point p9 = new Point(3,-3);
		
		Line l1 = new Line(p0,p1);
		Line l2 = new Line(p0,p3);
		Line l3 = new Line(p4,p5);
		Line l4 = new Line(p6,p7);
		Line l5 = new Line(p8,p9);
		
		Circle c1 = new Circle(p0, 5);
		
		Ellipse e1 = new Ellipse(p0, l1, l2);
		
		ArrayList<Line> list = new ArrayList<Line>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		Polygon pg1 = new Polygon(list);
		
		System.out.println(l1);
		
		
	}

}
