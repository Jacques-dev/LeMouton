package shape;

import java.util.Objects;

import point.Point;

public class Ellipse extends Shape {

	private final Line grandAxe, petitAxe;
	private final Point center;

	/**
	@param center is the center Point of the Ellipse
	@param grandAxe is the longest line belonging in the Ellipse
	@param grandAxe is the smallest line belonging in the Ellipse
	*/
    public Ellipse(Point center, Line grandAxe, Line petitAxe) {
    	this.center = center;
    	this.grandAxe=grandAxe;
    	this.petitAxe=petitAxe;
    }

    /**
	@return the perimeter of the Ellipse
	*/
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

    /**
	@return the area of the Ellipse
	*/
    @Override
    public double area() {
        return Math.PI * petitAxe.perimeter() * grandAxe.perimeter();
    }

    /**
	@param origine is the homothety origin
	@param ratio is the homothety ratio
	@return a new Ellipse after a homothety
	*/
	@Override
	public Ellipse homothety(Point p, int ratio) {
		float x = (center.getX()-p.getX())*ratio;
		float y = (center.getY()-p.getY())*ratio;
		
		float l1p1x = (petitAxe.getP1().getX()-p.getX())*ratio;
		float l1p1y = (petitAxe.getP1().getY()-p.getY())*ratio;
		float l1p2x = (petitAxe.getP2().getX()-p.getX())*ratio;
		float l1p2y = (petitAxe.getP2().getY()-p.getY())*ratio;
		Point l1p1 = new Point(l1p1x,l1p1y);
		Point l1p2 = new Point(l1p2x,l1p2y);
		Line l1 = new Line(l1p1,l1p2);
		
		float l2p1x = (petitAxe.getP1().getX()-p.getX())*ratio;
		float l2p1y = (petitAxe.getP1().getY()-p.getY())*ratio;
		float l2p2x = (petitAxe.getP2().getX()-p.getX())*ratio;
		float l2p2y = (petitAxe.getP2().getY()-p.getY())*ratio;
		Point l2p1 = new Point(l2p1x,l2p1y);
		Point l2p2 = new Point(l2p2x,l2p2y);
		Line l2 = new Line(l2p1,l2p2);
		
		return new Ellipse(new Point(x+center.getX(),y+center.getY()), l1, l2);
	}

	/**
	@param p is the new center Point of the Ellipse after translation
	@return a new Ellipse after a translation
	*/
	@Override
	public Ellipse translation(Point p) {
		return new Ellipse(p, grandAxe.translation(p), petitAxe.translation(p));
	}

	/**
	@param angle is the degree of rotation
	@return a new Ellipse after a rotation
	*/
	@Override
	public Ellipse rotation(int angle) {
		Point center = petitAxe.intersectionPoint(grandAxe);
		Line newGrandAxe = grandAxe.rotation(angle);
		Line newPetitAxe = petitAxe.rotation(angle);
		
		return new Ellipse(center,newGrandAxe,newPetitAxe);
	}

	/**
	@return a new Ellipse corresponding the its central symmetry
	*/
	@Override
	public Ellipse centralSymmetry(Point p) {
		Line newGrandAxe = grandAxe.centralSymmetry(p);
		Line newPetitAxe = petitAxe.centralSymmetry(p);
		
		Point newCenter = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return new Ellipse(newCenter,petitAxe,grandAxe);
	}

	/**
	@param l is the Line of symmetry
	@return a new Ellipse corresponding the its axial symmetry
	*/
	@Override
	public Ellipse axialSymmetry(Line l) {
		Line newGrandAxe = grandAxe.axialSymmetry(l);
		Line newPetitAxe = petitAxe.axialSymmetry(l);
		
		Point newCenter = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return new Ellipse(newCenter,petitAxe,grandAxe);
	}

	/**
	@return a textual representation of an Ellipse
	*/
	public String toString() {
		return center.toString() + "p:" + petitAxe.toString() + "g:" + grandAxe.toString();
	}
    
	/**
	@param o : is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Ellipse)) {return false;}
		Ellipse x = (Ellipse) o;
		return center == x.center && grandAxe == x.grandAxe && petitAxe == x.petitAxe;
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(center,grandAxe,petitAxe);
	}

}
