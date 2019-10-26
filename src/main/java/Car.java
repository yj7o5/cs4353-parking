public class Car {
    private Ticket ticket;
    private String numberPlate;

    public Car(String _numberPlate, Ticket _ticket) {
        numberPlate = _numberPlate;
        ticket = _ticket;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void handTicket(Ticket _ticket) throws ExpiredTicketException {
        if (_ticket.isExpired()) {
            throw new ExpiredTicketException(_ticket.getUsageDuration());
        }

        ticket = _ticket;
    }

    public Ticket returnTicket() {
        return ticket;
    }
}
