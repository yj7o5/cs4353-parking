import java.time.Duration;

/*
Policies:
    - Morning (1 - 12) 3% additional fee
    - Afternoon (12 - 4) 1% additional fee
    - Evening (4 - midnight) 0% additiona fee
Discounts:
    - parking duration < 1 hour 10% off
    - parking duration < 2 hour 5% off
    - parking duration < 3 hour 2% off
 */
public class CheapParkingGroup extends AbstractParkingGroup {
    @Override
    public Object getLatestPrices() {

    }

    @Override
    public int calcFinalCost(Car car) {
        Duration duration = car.returnTicket().getUsageDuration();
    }
}