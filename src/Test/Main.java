package Test;

import point.Point;
import shape.Line;
import shape.Shape;

public class Main {

	public static void main(String[] args) {
		
		Point p1 = new Point(1,3);
		Point p2= new Point(2,3);
		
		Line l1 = new Line(p1,p2);
		
		Point p3 = new Point(1,1);
		Point p4= new Point(2,2);
		
		Line l2 = new Line(p3,p4);
		
		l1 = l1.axialSymmetry(l2);
		
		System.out.println(l1);
		
		
	}

}
