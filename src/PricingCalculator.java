import java.time.Duration;
import java.util.HashMap;

public class PricingCalculator {
    private static HashMap<Duration, Integer> durationToCostMap;

    public static void initPricing() {
        durationToCostMap = new HashMap<Duration, Integer>();

        durationToCostMap.put(Duration.ofHours(1), 5);  // $5
        durationToCostMap.put(Duration.ofHours(2), 10); // $10
        durationToCostMap.put(Duration.ofHours(5), 20); // $20
        durationToCostMap.put(Duration.ofDays(1), 50);  // $50
    }

    public static int calcuateCost(Duration duration) {
        if (duration.compareTo(Duration.ofHours(1)) < 0) {
            return 5;   // charge $5
        }
        else if (duration.compareTo(Duration.ofHours(2)) < 0) {
            return 10;  // charge $10
        }
        else if (duration.compareTo(Duration.ofHours(5)) < 0) {
            return 20;  // charge $20
        }
        else {
            return 50;  // charge $50 - flat fee for more that 5 hours
        }
    }
}
