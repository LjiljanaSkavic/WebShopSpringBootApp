package springbootapp.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class HttpException extends RuntimeException {

    private HttpStatus httpStatus;
    private Object data;

    public HttpException() {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.data = null;
    }

    public HttpException(Object data) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, data);
    }

    public HttpException(HttpStatus httpStatus, Object data) {
        this.httpStatus = httpStatus;
        this.data = data;
    }
}
