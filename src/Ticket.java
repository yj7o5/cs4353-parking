import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private Duration usage;
    private boolean isUsed;
    private LocalDateTime receivedAt;

    public Ticket() {
        receivedAt = LocalDateTime.now();
    }

    public boolean isExpired() {
        return isUsed;
    }

    public Duration getUsageDuration() {
        return usage;
    }

    public Duration setExpired() {
        isUsed = true;
        usage = Duration.between(receivedAt, LocalDateTime.now());
        return getUsageDuration();
    }
}
