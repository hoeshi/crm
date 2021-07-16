package ch.zli.hoeshi.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Car Already exists")
public class CarAlreadyExistsException extends RuntimeException {
	public CarAlreadyExistsException() {
		super("", null, true, false);
	}
}
