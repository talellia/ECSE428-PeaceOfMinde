package ecse428.peaceOfMinde.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exceptions caused during runtime due to invalid input during
 * the creation of a ServiceOffering
 *
 * @author Gohar Saqib Fazal
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ServiceOfferingException extends Exception {
    /**
     * returns an exception
     *
     * @param message exception
     */
    public ServiceOfferingException(String message) {
        super(message);
    }
}