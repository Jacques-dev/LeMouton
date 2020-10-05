package shape;

import java.util.ArrayList;

import point.Point;

enum Type {
	TRIANGLE, SQUARE, RECTANGE, TRAPEZE, REGULAR, IRREGULAR;
}

public class Polygones extends Shape {

	private final Type type;
	private final ArrayList<Line> lines;
	
	public Polygones(ArrayList<Line> lines) {
		this.lines = lines;
		switch (lines.size()) {
		case 3:
			this.type = Type.TRIANGLE;
			break;
		case 4:
			int line1 = (int) lines.get(0).perimeter();
			int line2 = (int) lines.get(1).perimeter();
			int line3 = (int) lines.get(2).perimeter();
			int line4 = (int) lines.get(3).perimeter();
			
			if (line1 == line2 && line1 == line3 && line1 == line4) { //check square
				this.type = Type.SQUARE;
				break;
			}
			
			
			
		}
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
