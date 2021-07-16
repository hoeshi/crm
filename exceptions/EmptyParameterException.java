package ch.zli3.ksh18a.crm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Empty parameter")
public class EmptyParameterException extends RuntimeException {
    public EmptyParameterException() {
        super("", null, true, false);
    }
}
