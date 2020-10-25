package shape;

import java.util.Objects;

import point.Point;

public class Ellipse extends Shape {

	private final Line grandAxe, petitAxe;
	private final Point center;

    public Ellipse(Point center, Line grandAxe, Line petitAxe) {
    	this.center = center;
    	this.grandAxe=grandAxe;
    	this.petitAxe=petitAxe;
    }

    @Override
    public double perimeter() {
        float resultat = 0;
        float pcarre = (float) (petitAxe.perimeter() * petitAxe.perimeter());
        float gcarre = (float) (grandAxe.perimeter() * grandAxe.perimeter());
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
        return Math.PI * petitAxe.perimeter() * grandAxe.perimeter();
    }

	@Override
	public Shape homothety(Point p, int ratio) {
		double x = (center.getX()-p.getX())*ratio;
		double y = (center.getY()-p.getY())*ratio;
		
		double l1p1x = (petitAxe.getP1().getX()-p.getX())*ratio;
		double l1p1y = (petitAxe.getP1().getY()-p.getY())*ratio;
		double l1p2x = (petitAxe.getP2().getX()-p.getX())*ratio;
		double l1p2y = (petitAxe.getP2().getY()-p.getY())*ratio;
		Point l1p1 = new Point(l1p1x,l1p1y);
		Point l1p2 = new Point(l1p2x,l1p2y);
		Line l1 = new Line(l1p1,l1p2);
		
		double l2p1x = (petitAxe.getP1().getX()-p.getX())*ratio;
		double l2p1y = (petitAxe.getP1().getY()-p.getY())*ratio;
		double l2p2x = (petitAxe.getP2().getX()-p.getX())*ratio;
		double l2p2y = (petitAxe.getP2().getY()-p.getY())*ratio;
		Point l2p1 = new Point(l2p1x,l2p1y);
		Point l2p2 = new Point(l2p2x,l2p2y);
		Line l2 = new Line(l2p1,l2p2);
		
		return new Ellipse(new Point(x+center.getX(),y+center.getY()), l1, l2);
	}

	@Override
	public Shape translation(Point p) {
		return new Ellipse(p, grandAxe.translation(p), petitAxe.translation(p));
	}

	@Override
	public Shape rotation(int angle) {
		
	}

	@Override
	public Shape centralSymmetry() {
		
	}

	@Override
	public Shape axialSymmetry(Line l) {
		
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
