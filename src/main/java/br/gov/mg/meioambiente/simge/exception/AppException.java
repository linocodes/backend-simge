package br.gov.mg.meioambiente.simge.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = -4490060671494243485L;

	public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
    
}
