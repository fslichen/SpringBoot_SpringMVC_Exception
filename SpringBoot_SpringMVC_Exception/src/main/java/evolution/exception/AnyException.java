package evolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error Defined by Chen")
public class AnyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
