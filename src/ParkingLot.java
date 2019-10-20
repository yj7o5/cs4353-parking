import Exceptions.ParkingUnavailableException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

public class ParkingLot {
    private int capacity;

    private ArrayList<Object> parkingSpots;

    public ParkingLot(int _capacity) {
        parkingSpots = new ArrayList<Object>(_capacity);
        capacity = _capacity;
    }

    private boolean hasSpace() {
        return parkingSpots.size() < capacity;
    }

    public void enterCar(Object car) throws ParkingUnavailableException {
        if (!hasSpace()) {
            throw new ParkingUnavailableException();
        }

        // cat.ticket = new Ticket();
    }

    public void exitCar(Object car) {
        // Charge the car

        parkingSpots.remove(car);
    }
}
