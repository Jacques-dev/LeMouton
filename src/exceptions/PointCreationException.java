package exceptions;

@SuppressWarnings("serial")
public class PointCreationException extends Exception{
	public PointCreationException() {
        super ("A Point has been created with Null arguments");
    }

}
