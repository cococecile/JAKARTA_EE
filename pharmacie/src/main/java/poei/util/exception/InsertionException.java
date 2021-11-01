package  poei.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsertionException extends RuntimeException {

    public InsertionException(String msg){
        super(msg);
    }
    
}
