package ai.ineuron.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ai.ineuron.ExceptionHandling.TouristExceptionHandling;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(TouristExceptionHandling.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFoundException(TouristExceptionHandling te) {

		System.out.println("ErrorHandler.handleTouristNotFoundException()");
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "404 - Not Found");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllTypeException(Exception e) {
		System.out.println("ErrorHandler.handleAllTypeException()");

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "404 - Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
