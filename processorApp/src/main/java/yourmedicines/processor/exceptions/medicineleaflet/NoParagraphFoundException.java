package yourmedicines.processor.exceptions.medicineleaflet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoParagraphFoundException extends RuntimeException {

    public NoParagraphFoundException(String message) {
        super(message);
    }
}
