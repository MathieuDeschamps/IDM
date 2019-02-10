package exceptions;

public class IdAlreadyExists extends Exception{

	private static final long serialVersionUID = 1L;
	
	public IdAlreadyExists(String message) {
		super(message);
	}

}
