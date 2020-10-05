package draw;

import java.util.ArrayList;
import java.util.Objects;

import image.Image;

public class Draw {
	
	private final ArrayList<Image> draw;
	
	public Draw(ArrayList<Image> draw) {
		this.draw = draw;
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
		if (!(o instanceof Draw)) {return false;}
		Draw x = (Draw) o;
		return draw.equals(x.draw);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(draw);
	}
}
