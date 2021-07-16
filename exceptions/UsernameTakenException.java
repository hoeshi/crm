package ch.zli3.ksh18a.crm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Username taken")
public class UsernameTakenException extends RuntimeException {
    public UsernameTakenException() {
        super("", null, true, false);
    }
}
