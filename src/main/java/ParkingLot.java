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

    public void enterCar(String numberPlate) throws ParkingUnavailableException, ExpiredTicketException {
        if (!hasSpace()) {
            throw new ParkingUnavailableException();
        }

        Ticket ticket = new Ticket();
        Car car = new Car(numberPlate, ticket);
        parkingSpots.add(car);
        car.handTicket(ticket);
    }

    public Car exitCar(String numberPlate) {
        Car car = parkingSpots.stream()
                .filter(f -> f.getNumberPlate().equals(numberPlate))
                .findFirst().get();

        Ticket ticket = car.returnTicket();
        Duration duration = ticket.setExpired();

        totalMoney += PricingCalculator.calcuateCost(duration);
        parkingSpots.remove(car);

        return car;
    }
}
