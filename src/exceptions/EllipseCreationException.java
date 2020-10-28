package exceptions;

@SuppressWarnings("serial")
public class EllipseCreationException extends Exception{
	public EllipseCreationException(String s) {
        super ("Somme of the arguments are not receivable : " + s);
    }
}
