public class ExpiredTicketException extends Exception {
    public String message;

    public ExpiredTicketException(Ticket ticket) {
        message = String.format("This ticket has been used for %s duration", ticket.getUsageDuration().toString());
    }

    @Override
    public String getMessage() {
        return message;
    }
}
