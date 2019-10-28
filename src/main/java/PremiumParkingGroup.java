/*
Policies:
    - Morning (1 - 12) 5% additional fee
    - Afternoon (12 - 4) 2% additional fee
    - Evening (4 - midnight) 0% additiona fee
Discounts:
    - parking duration < 1 hour 5% off
    - parking duration < 2 hour 3% off
    - parking duration < 3 hour 1% off
 */
public class ExpensiveParkingGroup extends AbstractParkingGroup {


    @Override
    public int calcFinalCost(Car car) {
        return 0;
    }
}
