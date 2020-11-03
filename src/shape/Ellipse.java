package shape;

import java.util.Objects;

import exceptions.EllipseCreationException;
import exceptions.LineCreationException;
import point.Point;

public class Ellipse extends Shape {

	private final Line grandAxe, petitAxe;
	private final Point center;

	/**
	@param center is the center Point of the Ellipse
	@param l1 is one of the lines belonging in the Ellipse from center
	@param l2 is one of the lines belonging in the Ellipse from center
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
	@throws LineCreationException check if no Null argument are given 
	*/
    public Ellipse(Point center, Line l1, Line l2) throws EllipseCreationException, LineCreationException {
    	if (l1.perimeter() == l2.perimeter()) {
    		throw new EllipseCreationException("'l1' and 'l2' are similar, meaning that this will not create an Ellipse but a Circle");
    	}
    	
    	
    	if (center.equals(l1.intersectionPoint(l2))) {
    		if (l1.isOrthogonal(l2)) {
		    	this.center = center;
		    	
		    	Point newPoint;
		    	Line grandAxe, petitAxe;
		    	
		    	if (l1.perimeter() < l2.perimeter()) {
		    		grandAxe = l2;
		    		petitAxe = l1;
		    	} else {
		    		grandAxe = l1;
		    		petitAxe = l2;
		    	}
		    	
		    	if (grandAxe.getP1().equals(center)) {
		    		newPoint = grandAxe.getP1().symmetry(center);
		    		this.grandAxe = new Line(grandAxe.getP2(), newPoint);
		    	} else {
		    		newPoint = grandAxe.getP1().symmetry(center);
		    		this.grandAxe = new Line(grandAxe.getP1(), newPoint);
		    	}
		    	
		    	if (petitAxe.getP1().equals(center)) {
		    		newPoint = petitAxe.getP1().symmetry(center);
		    		this.petitAxe = new Line(petitAxe.getP2(), newPoint);
		    	} else {
		    		newPoint = petitAxe.getP1().symmetry(center);
		    		this.petitAxe = new Line(petitAxe.getP1(), newPoint);
		    	}
    		} else {
    			throw new EllipseCreationException("'l1' and 'l2' have to be orthogonal");
    		}
    	} else {
    		throw new EllipseCreationException("'l1' and 'l2' have to contains a same point which has to be 'center'");
    	}
    }
    
    /**
	@param center is the center Point of the Ellipse
	@param grandAxe is the longest line belonging in the Ellipse
	@param petitAxe is the smallest line belonging in the Ellipse
	@return a new Ellipse
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
    @throws LineCreationException check if no Null argument are given 
	*/
    public Ellipse newEllipse(Point center, Line grandAxe, Line petitAxe) throws EllipseCreationException, LineCreationException{
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
	@param p is the homothety origin
	@param ratio is the homothety ratio
	@return a new Ellipse after a homothety
    @throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
    @throws LineCreationException check if no Null argument are given 
	*/
	@Override
	public Ellipse homothety(Point p, int ratio) throws EllipseCreationException, LineCreationException{;
		
		Point l1p1 = new Point(grandAxe.getP1());
		Point l1p2 = new Point(grandAxe.getP2());
		Line l1 = new Line(l1p1,l1p2).homothety(p, ratio);
		
		
		Point l2p1 = new Point(petitAxe.getP1());
		Point l2p2 = new Point(petitAxe.getP2());
		Line l2 = new Line(l2p1,l2p2).homothety(p, ratio);
		
		Point newCenter = l1.intersectionPoint(l2);
		
		return newEllipse(newCenter, l1, l2);
	}

	/**
	@param p is the new center Point of the Ellipse after translation
	@return a new Ellipse after a translation
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
	@throws LineCreationException check if no Null argument are given 
	*/
	@Override
	public Ellipse translation(Point p) throws EllipseCreationException, LineCreationException{
		return newEllipse(p, grandAxe.translation(p), petitAxe.translation(p));
	}

	/**
	@param angle is the degree of rotation
	@return a new Ellipse after a rotation
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
	@throws LineCreationException check if no Null argument are given 
	*/
	@Override
	public Ellipse rotation(int angle) throws EllipseCreationException, LineCreationException{
		Line newGrandAxe = grandAxe.rotation(angle);
		Line newPetitAxe = petitAxe.rotation(angle);
		Point center = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return newEllipse(center,newGrandAxe,newPetitAxe);
	}

	/**
	@return a new Ellipse corresponding the its central symmetry
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
	@throws LineCreationException check if no Null argument are given 
	*/
	@Override
	public Ellipse centralSymmetry(Point p) throws EllipseCreationException, LineCreationException{
		Line newGrandAxe = grandAxe.centralSymmetry(p);
		Line newPetitAxe = petitAxe.centralSymmetry(p);
		
		Point newCenter = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return newEllipse(newCenter,newGrandAxe,newPetitAxe);
	}

	/**
	@param l is the Line of symmetry
	@return a new Ellipse corresponding the its axial symmetry
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle 
	@throws LineCreationException check if no Null argument are given 
	*/
	@Override
	public Ellipse axialSymmetry(Line l) throws EllipseCreationException, LineCreationException{
		Line newGrandAxe = grandAxe.axialSymmetry(l);
		Line newPetitAxe = petitAxe.axialSymmetry(l);
		
		Point newCenter = newGrandAxe.intersectionPoint(newPetitAxe);
		
		return newEllipse(newCenter,newGrandAxe,newPetitAxe);
	}

	/**
	@return a textual representation of an Ellipse
	*/
	public String toString() {
		
		StringBuilder resultat = new StringBuilder("\t\t\tEllipse\n");
		
		resultat.append("\t\t\t\tcenter : " + center + "\n\t\t\t\tGrand Axe : \n\t" + grandAxe + "\n\t\t\t\tPetit Axe : \n\t" + petitAxe + "\n");
	
		return resultat.toString();
	}
    
	/**
	@param o : is an object with no type defined
    @return a boolean which significate if this Arc is equal to another one
	*/
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Ellipse)) {return false;}
		Ellipse x = (Ellipse) o;
		return center.equals(x.center) && grandAxe.equals(x.grandAxe) && petitAxe.equals(x.petitAxe);
	}
	
	/**
    @return a hash code value for the object
	*/
	@Override
	public int hashCode() {
		return Objects.hash(center,grandAxe,petitAxe);
	}
	
	/** 
	@return a copy of Ellipse
	@throws EllipseCreationException check for orthogonality, if lines cross the center point, and if it's not a circle
	@throws LineCreationException check if no Null argument are given
	*/
	@Override
	public Ellipse copy() throws EllipseCreationException, LineCreationException{
		return new Ellipse(this.center, this.grandAxe, this.petitAxe);
	}

}
