package image;

import java.util.ArrayList;
import java.util.Objects;

import shape.Shape;

public class Image {
	
	private final ArrayList<Shape> image;
	
	public Image(ArrayList<Shape> image) {
		this.image = image;
	}
	
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Image)) {return false;}
		Image x = (Image) o;
		return image.equals(x.image);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(image);
	}
}
