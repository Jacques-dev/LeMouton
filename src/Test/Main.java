package Test;

import point.Point;
import shape.Line;
import shape.Shape;

public class Main {

	public static void main(String[] args) {
		
		Point p1 = new Point(0,0);
		Point p2= new Point(1,0);
		
		Shape l1 = new Line(p1,p2);
		
		System.out.println(l1);
		
		l1 = l1.translation(new Point(0,2));
		
		System.out.println(l1);
	}

}
