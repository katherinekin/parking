import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class ParkingLot {
    private int capacity = 20;
    // make a hash to keep track of car spaces
    // make a hash to keep track of moped spaces
    // make a hash to keep track of handicap spaces

    // If car arrives, check for open spots based on type
    private Map<Vehicle, Integer> takenSpaces = new HashMap<Vehicle, Integer>();
    private double totalProfit = 0.0;

    public LocalDateTime getCurrentTime () {
        return LocalDateTime.now();
    }

    public Boolean isFull() {
        if (takenSpaces.size() <= capacity) {
            return true;
        }
        return false;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getParkingSpace(Car car) {
        return takenSpaces.get(car);
    }
}