package shape;

public class Circle extends Shape {
	
	private final double radius;
	private final double pi = Math.PI;
	
	public Circle(double radius) {
		this.radius = radius;
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
		return pi * Math.pow(radius,  2);
	}

	@Override
	public double perimeter() {
		return 2 * pi * radius;
	}

}
