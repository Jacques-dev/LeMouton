package shape;

import java.util.Objects;

import exceptions.GeometricalException;
import point.Point;

public class Ellipse extends Shape {

	private final Line grandAxe, petitAxe;
	private final Point center;

	/**
	@param center is the center Point of the Ellipse
	@param grandAxe is the longest line belonging in the Ellipse from center
	@param petitAxe is the smallest line belonging in the Ellipse from center
	@throws GeometricalException 
	*/
    public Ellipse(Point center, Line grandAxe, Line petitAxe) throws GeometricalException {
    	if (center.equals(grandAxe.intersectionPoint(petitAxe))) {
	    	this.center = center;
	    	
	    	Point newPoint;
	    	
	    	if (grandAxe.getP1().equals(center)) {
	    		newPoint = symmetry(grandAxe.getP1(), center);
	    		this.grandAxe = new Line(grandAxe.getP2(), newPoint);
	    	} else {
	    		newPoint = symmetry(grandAxe.getP1(), center);
	    		this.grandAxe = new Line(grandAxe.getP1(), newPoint);
	    	}
	    	
	    	if (petitAxe.getP1().equals(center)) {
	    		newPoint = symmetry(petitAxe.getP1(), center);
	    		this.petitAxe = new Line(petitAxe.getP2(), newPoint);
	    	} else {
	    		newPoint = symmetry(petitAxe.getP1(), center);
	    		this.petitAxe = new Line(petitAxe.getP1(), newPoint);
	    	}
    	} else {
    		throw new GeometricalException("[grandAxe] and [petitAxe] have to contains the same point as [center]");
    	}
    }
    
    /**
	@param center is the center Point of the Ellipse
	@param grandAxe is the longest line belonging in the Ellipse
	@param petitAxe is the smallest line belonging in the Ellipse
	@throws GeometricalException 
	*/
    public Ellipse newEllipse(Point center, Line grandAxe, Line petitAxe) throws GeometricalException {
    	Line newGrandAxe = new Line(grandAxe.getP1(), grandAxe.centerOfLine());
    	Line newPetitAxe = new Line(petitAxe.getP1(), petitAxe.centerOfLine());
    	return new Ellipse(center, newGrandAxe, newPetitAxe);
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
        return Math.PI * (petitAxe.perimeter()/2) * (grandAxe.perimeter()/2);
    }

    /**
	@param origine is the homothety origin
	@param ratio is the homothety ratio
	@return a new Ellipse after a homothety
    @throws GeometricalException 
	*/
	@Override
	public Ellipse homothety(Point p, int ratio) throws GeometricalException {
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
		
		return newEllipse(new Point(x+center.getX(),y+center.getY()), l1, l2);
	}

	/**
	@param p is the new center Point of the Ellipse after translation
	@return a new Ellipse after a translation
	@throws GeometricalException 
	*/
	@Override
	public Ellipse translation(Point p) throws GeometricalException {
		return newEllipse(p, grandAxe.translation(p), petitAxe.translation(p));
	}

	/**
	@param angle is the degree of rotation
	@return a new Ellipse after a rotation
	@throws GeometricalException 
	*/
	@Override
	public Ellipse rotation(int angle) throws GeometricalException {
		Point center = petitAxe.intersectionPoint(grandAxe);
		Line newGrandAxe = grandAxe.rotation(angle);
		Line newPetitAxe = petitAxe.rotation(angle);
		
		return newEllipse(center,newGrandAxe,newPetitAxe);
	}

	/**
	@return a new Ellipse corresponding the its central symmetry
	@throws GeometricalException 
	*/
	@Override
	public Ellipse centralSymmetry(Point p) throws GeometricalException {
		Line newGrandAxe = grandAxe.centralSymmetry(p);
		Line newPetitAxe = petitAxe.centralSymmetry(p);
		
		Point newCenter = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return newEllipse(newCenter,petitAxe,grandAxe);
	}

	/**
	@param l is the Line of symmetry
	@return a new Ellipse corresponding the its axial symmetry
	@throws GeometricalException 
	*/
	@Override
	public Ellipse axialSymmetry(Line l) throws GeometricalException {
		Line newGrandAxe = grandAxe.axialSymmetry(l);
		Line newPetitAxe = petitAxe.axialSymmetry(l);
		
		Point newCenter = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return newEllipse(newCenter,petitAxe,grandAxe);
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
