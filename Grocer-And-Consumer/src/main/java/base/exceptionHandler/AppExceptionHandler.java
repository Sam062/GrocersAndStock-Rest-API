package base.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import base.exceptions.AppError;
import base.exceptions.DataNotRegisteredException;
import base.exceptions.DataReadingException;

@RestController
@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = DataNotRegisteredException.class)
	public ResponseEntity<AppError> handleDataNotRegisteredException(){
		return new ResponseEntity<AppError>(new AppError(500,"Sorry!! Something Went Wrong."),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = DataReadingException.class)
	public ResponseEntity<AppError> handleDataReadingException() {
		return new ResponseEntity<AppError>(new AppError(404,"DATA NOT FOUND."),HttpStatus.NOT_FOUND);
	}

}
