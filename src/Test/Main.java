package Test;

import java.util.ArrayList;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import image.Image;
import point.Point;
import shape.Circle;
import shape.Ellipse;
import shape.Line;
import shape.Polygon;
import shape.Shape;
import shape.ShapesMethodes;

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
		Line l6 = new Line(p1,p8);
		Line l7 = new Line(p8,p3);
		Line l8 = new Line(p3,p4);
		Line l9 = new Line(p4,p0);

		Circle c1 = new Circle(p0, 5);
		
		Ellipse e1 = new Ellipse(p0, l1, l2);
		
		ArrayList<Line> linesList = new ArrayList<Line>();
		linesList.add(l1);
		linesList.add(l6);
		linesList.add(l7);
		linesList.add(l8);
		linesList.add(l9);
		
		Polygon poly1 = new Polygon(linesList);
		
		Image i1 = new Image();
		i1.add(l1);
		i1.add(l2);
		i1.add(l3);
		i1.add(l4);
		i1.add(l5);
		i1.add(l6);
		i1.add(l7);
		i1.add(l8);
		i1.add(l9);
		i1.add(c1);
		i1.add(e1);
		i1.add(poly1);
		
		i1.perimeter();
		i1.area();
		((ShapesMethodes) i1).homothety(p2, 10);
		((ShapesMethodes) i1).translation(p2);
		((ShapesMethodes) i1).rotation(35);
		((ShapesMethodes) i1).centralSymmetry(p4);
		((ShapesMethodes) i1).axialSymmetry(l2);
		
		/*
		ArrayList<Line> list = new ArrayList<Line>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		Polygon pg1 = new Polygon(list);
		
		System.out.println(l1);
		*/
		
	}

}
