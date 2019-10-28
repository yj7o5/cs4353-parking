import java.util.HashMap;

public abstract class ParkingGroup {
    public String groupName;
    public abstract HashMap<String, String> policies();
}
