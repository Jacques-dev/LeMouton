package exceptions;

@SuppressWarnings("serial")
public class LineCreationException extends Exception{
	public LineCreationException() {
        super ("A Line has been created with Null arguments");
    }

}
