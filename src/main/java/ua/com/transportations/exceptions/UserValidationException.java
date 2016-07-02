package ua.com.transportations.exceptions;

/**
 * Created by d.fedorov on 28.06.16.
 */
public class UserValidationException extends IllegalArgumentException {

    public UserValidationException(long userId, String message) {
        super(String.format("%s for User[%d]", message, userId));
    }
}
