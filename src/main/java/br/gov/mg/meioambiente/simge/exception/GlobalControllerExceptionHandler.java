package br.gov.mg.meioambiente.simge.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import br.gov.mg.meioambiente.simge.pojo.exception.RestErrorInfo;


@ControllerAdvice
class GlobalControllerExceptionHandler implements Serializable {
	
	private static final long serialVersionUID = -5149908048961962061L;
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppException.class)
    public
    @ResponseBody
    RestErrorInfo handleAppException(AppException ex, WebRequest request, HttpServletResponse response) {
        //log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());

        return new RestErrorInfo(ex, "You messed up.");
    }
    

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public
    @ResponseBody
    RestErrorInfo handleResourceNotFoundException(NotFoundException ex, WebRequest request, HttpServletResponse response) {
        //log.info("ResourceNotFoundException handler:" + ex.getMessage());

        return new RestErrorInfo(ex, "Sorry I couldn't find it.");
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public
    @ResponseBody
    RestErrorInfo handleDataFormatException(DataFormatException ex, WebRequest request, HttpServletResponse response) {
        //log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());

        return new RestErrorInfo(ex, "You messed up.");
    }
    
    /*
    
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundExceptionSade.class)
	@ResponseBody
	MensagensErro handleNotFound(NotFoundExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ParametrosInvalidosExceptionSade.class)
	@ResponseBody
	MensagensErro handleParametrosInvalidos(ParametrosInvalidosExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DadosEmConflitoExceptionSade.class)
	@ResponseBody
	MensagensErro handleConflito(DadosEmConflitoExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLExceptionSade.class)
	@ResponseBody
	MensagensErro handleSQL(SQLExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(IoExceptionSade.class)
	@ResponseBody
	MensagensErro handleIO(IoExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(GeoServerException.class)
	@ResponseBody
	MensagensErro handleGeoServer(GeoServerException ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CastException.class)
	@ResponseBody
	MensagensErro handleCast(CastException ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PermissaoExceptionSade.class)
	@ResponseBody
	MensagensErro handleGeneric(PermissaoExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(AutenticacaoExceptionSade.class)
	@ResponseBody
	MensagensErro handleGeneric(AutenticacaoExceptionSade ex) {
		return ex.getMensagensErro();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SadeException.class)
	@ResponseBody
	MensagensErro handleGeneric(SadeException ex) {
		return ex.getMensagensErro();
	}
	
	*/

}
