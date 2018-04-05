package br.gov.mg.meioambiente.simge.exception;

/**
 * for HTTP 400 errors
 */
public final class DataFormatException extends RuntimeException {
	

	private static final long serialVersionUID = -479051828863114005L;

	public DataFormatException() {
        super();
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}