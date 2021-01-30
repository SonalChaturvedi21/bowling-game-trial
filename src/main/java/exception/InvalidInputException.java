package exception;

public class InvalidInputException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String exception, Throwable ex) {
		super(exception, ex);
	}
}
