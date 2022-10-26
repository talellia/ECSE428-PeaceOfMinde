package ecse428.peaceOfMinde.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exceptions caused during runtime due to invalid input during
 * the login and registration process
 *
 * @author Gohar Saqib Fazal
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PersonException extends Exception {
    /**
     * returns an exception
     *
     * @param message exception
     */
    public PersonException(String message) {
        super(message);
    }
}