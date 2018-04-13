package br.gov.mg.meioambiente.simge.exception;

/**
 * For HTTP 404 errros
 */
public class NotFoundException extends AppException {

	private static final long serialVersionUID = -7081454042660263122L;

	public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

}