import Exceptions.ExpiredTicketException;
import Exceptions.ParkingUnavailableException;

import java.time.Duration;
import java.util.ArrayList;

public class ParkingLot {
    private int capacity;
    private int totalMoney;

    private ArrayList<Car> parkingSpots;

    public ParkingLot(int _capacity) {
        parkingSpots = new ArrayList<Car>(_capacity);
        capacity = _capacity;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    private boolean hasSpace() {
        return parkingSpots.size() < capacity;
    }

    public void enterCar(Car car) throws ParkingUnavailableException, ExpiredTicketException {
        if (!hasSpace()) {
            throw new ParkingUnavailableException();
        }

        Ticket ticket = new Ticket();
        car.handTicket(ticket);
    }

    public void exitCar(Car car) {
        parkingSpots.remove(car);
        Ticket ticket = car.returnTicket();

        Duration duration = ticket.setExpired();
        totalMoney += PricingCalculator.calcuateCost(duration);
    }
}
