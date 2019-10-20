import Exceptions.ExpiredTicketException;
import Exceptions.ParkingUnavailableException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Data> list = new Main().readFileData();
        int totalCars = list.size();

        ParkingLot lot = new ParkingLot(5);

        int timeInterval = 1;
        int totalCarsExit = 0;

        while (totalCarsExit != totalCars) {
            for(Data d : list) {
                if (timeInterval == d.arrival) {
                    System.out.println(String.format("Car %s entering lot", d.carNumberPlate));

                    try {
                        lot.enterCar(d.carNumberPlate);
                    }
                    catch (ParkingUnavailableException parkingException) {
                        d.arrival += 1; // bump arrival and departure to try next
                        d.departure += 1;
                        System.out.println(String.format("Car %s parking denied - parking full", d.carNumberPlate));
                    }
                    catch (ExpiredTicketException expiredException) {
                        System.out.println(String.format("Car %s parking denied - expired ticket provied", d.carNumberPlate));
                    }
                }

                else if (timeInterval == d.departure) {
                    System.out.println(String.format("Car %s exiting parking lot", d.carNumberPlate));
                    Car car = lot.exitCar(d.carNumberPlate);
                    Integer cost = PricingCalculator.calcuateCost(car.returnTicket().getUsageDuration());
                    System.out.println(String.format("Car %s exited parking lot - duration: %s, cost: $%s", car.getNumberPlate(), car.returnTicket().getUsageDuration(), cost));

                    totalCarsExit += 1;
                }
            }

            timeInterval += 1;
            Thread.sleep(1000); // To give
        }

        System.out.println(String.format("Total Cars Served: %s, Total Profit: $%s", totalCars, lot.getTotalMoney()));
    }

    public ArrayList<Data> readFileData() {
        ArrayList<Data> collection = new ArrayList<Data>();
        InputStream data = Main.class.getResourceAsStream("cars.dat");
        Scanner sc = new Scanner(data);

        sc.nextLine(); // skip file headers

        while(sc.hasNext()) {
            Data d = new Data(sc.next(), sc.nextInt(), sc.nextInt());
            collection.add(d);
        }

        return collection;
    }

    private class Data {
        public String carNumberPlate;
        public int arrival;
        public int departure;

        public Data(String plate, int _arrival, int _departure) {
            carNumberPlate = plate;
            arrival = _arrival;
            departure = _departure;
        }
    }
}
