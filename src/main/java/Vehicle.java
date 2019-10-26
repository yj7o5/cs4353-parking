public abstract class Vehicle {
    private Ticket ticket;
    public VehicleType type;
    public int yearBuilt;

    public void handTicket(Ticket _ticket) throws ExpiredTicketException {
        if (_ticket.isExpired()) {
            throw new ExpiredTicketException(_ticket);
        }

        ticket = _ticket;
    }

    public Ticket returnTicket(Ticket ticket) {
        return ticket;
    }
}
