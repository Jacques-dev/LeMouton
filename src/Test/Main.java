package Test;

import java.util.ArrayList;

import containers.Draw;
import containers.Image;
import containers.Mural;
import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import point.Point;
import shape.Circle;
import shape.Ellipse;
import shape.Line;
import shape.Polygon;

public class Main {

	public static void main(String[] args) throws LineCreationException, EllipseCreationException{
		
		
		
		Point p0 = new Point(-4,6);
		Point p1 = new Point(2,0);
		Point p2 = new Point(-2,2);
		Point p3 = new Point(0,4);
		Point p4 = new Point(2,2);
		Point p5 = new Point(4/3,3);
		
		Line l1 = new Line(p0,p1);
		Line l2 = new Line(p2,p3);
		Line l3 = new Line(p1,p5);
		Line l4 = new Line(p5,p3);
		Line l5 = new Line(p3,p4);
		Line l6 = new Line(p4,p0);
		
		Circle c1 = new Circle(p0, 5);
		
		Ellipse e1 = new Ellipse(l1.centerOfLine(), l1, l2);
		
		ArrayList<Line> linesList = new ArrayList<Line>();
		linesList.add(l1);
		linesList.add(l3);
		linesList.add(l4);
		linesList.add(l5);
		linesList.add(l6);
		
		Polygon poly1 = new Polygon(linesList);
		
		Image i1 = new Image();
		i1.add(l1);
		i1.add(c1);
		i1.add(e1);
		i1.add(poly1);
		
		Image i2 = new Image();
		i2.add(l1);
		i2.add(c1);
		i2.add(e1);
		i2.add(poly1);
		
		System.out.println(i2.perimeter());
		System.out.println(i2.area());
		i2=i2.homothety(p2, 10);
		i2=i2.translation(p2);
		i2=i2.rotation(45);
		i2=i2.centralSymmetry(p4);
		i2=i2.axialSymmetry(l2);
		
		Draw d1 = new Draw();
		d1.add(i1);
		d1.add(i2);
		
		Draw d2 = new Draw();
		d2.add(i1);
		d2.add(i2);
		
		System.out.println(d2.perimeter());
		System.out.println(d2.area());
		d2=d2.homothety(p2, 10);
		d2=d2.translation(p2);
		d2=d2.rotation(45);
		d2=d2.centralSymmetry(p4);
		d2=d2.axialSymmetry(l2);
		
		Mural m1 = new Mural();
		m1.add(d1);
		m1.add(d2);
		
		System.out.println(m1);
	}

}
