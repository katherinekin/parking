import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 20;
    // make a hash to keep track of cars and location
    private Map<Car, Integer> takenSpaces = new HashMap<Car, Integer>();
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