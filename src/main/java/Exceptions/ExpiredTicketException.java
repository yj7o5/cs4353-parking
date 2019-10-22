package Exceptions;

import java.time.Duration;

public class ExpiredTicketException extends Exception {
    public String message;

    public ExpiredTicketException(Duration duration) {
        message = String.format("This ticket has been used for %s duration", duration.toString());
    }

    @Override
    public String getMessage() {
        return message;
    }
}
