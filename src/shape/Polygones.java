package shape;

import java.util.ArrayList;

enum Type {
	TRIANGLE, SQUARE, RECTANGE, TRAPEZE, REGULAR, IRREGULAR;
}

public class Polygones extends Shape {

	private final ArrayList<Line> sides;
	private Type type;
	
	public Polygones(ArrayList<Line> sides) {
		this.sides = sides;
		switch (sides.size()) {
		case 3:
			this.type = Type.TRIANGLE;
			break;
		case 4:
			
		}
	}
	
	@Override
	public void homothety() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ratation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void centralSymmetry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axialSymmetry() {
		// TODO Auto-generated method stub
		
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
