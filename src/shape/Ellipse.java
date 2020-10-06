package shape;

import java.util.Objects;

import point.Point;

public class Ellipse extends Shape {

	private final int grandAxe, petitAxe;
	private final Point center;

    public Ellipse(Point center, int grandAxe, int petitAxe) {
    	this.center = center;
    	this.grandAxe=grandAxe;
    	this.petitAxe=petitAxe;
    }

    @Override
    public double perimeter() {
        float resultat = 0;
        float pcarre = petitAxe * petitAxe;
        float gcarre = grandAxe * grandAxe;
        float sinus, cosinus;

        for (int i = 0; i < 1000; i++) {
	    sinus=(float)Math.sin(i*Math.PI/2000);
	    cosinus=(float)Math.cos(i*Math.PI/2000);
	    resultat += Math.sqrt(pcarre * sinus * sinus + gcarre * cosinus *cosinus);
        }
        resultat *= 4*Math.PI / 2000;
        return resultat;
    }

    @Override
    public double area() {
        return Math.PI * petitAxe * grandAxe;
    }

	@Override
	public Shape homothety(Point p, int ratio) {
		double x = (center.getX()-p.getX())*ratio;
		double y = (center.getY()-p.getY())*ratio;
		return new Ellipse(new Point(x+center.getX(),y+center.getY()), grandAxe*ratio, petitAxe*ratio);
	}

	@Override
	public Shape translation(Point p) {
		return new Ellipse(p, grandAxe, petitAxe);
	}

	@Override
	public Shape rotation() {
		return new Ellipse(center, petitAxe, grandAxe);
	}

	@Override
	public Shape centralSymmetry() {
		return new Ellipse(symmetry(center), grandAxe, petitAxe);
	}

	@Override
	public Shape axialSymmetry(String axe) {
		switch (axe) {
		case "x":
			return new Ellipse(symmetryX(center), grandAxe, petitAxe);
		case "y":
			return new Ellipse(symmetryY(center), grandAxe, petitAxe);
		default:
			throw new IllegalArgumentException("x or y argument only");
		}
	}

    
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Ellipse)) {return false;}
		Ellipse x = (Ellipse) o;
		return center == x.center && grandAxe == x.grandAxe && petitAxe == x.petitAxe;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(center,grandAxe,petitAxe);
	}

}
