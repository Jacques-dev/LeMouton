package exceptions;

@SuppressWarnings("serial")
public class GeometricalException extends Exception{
	public GeometricalException(String s) {
        super ("Somme of the arguments are not receivable : " + s);
    }
}
