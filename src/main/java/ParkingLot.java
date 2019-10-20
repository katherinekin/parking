import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;


public class ParkingLot {
    private int capacity = 20;
    // make a hash to keep track of car spaces
    // make a hash to keep track of moped spaces
    // make a hash to keep track of handicap spaces

    // If car arrives, check for open spots based on type
    private Map<Vehicle, Integer> takenSpaces = new HashMap<Vehicle, Integer>();
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    private double dollarPerHour = 2.0;  // charge each car per hour
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

    public void setVehicleList(String filename) throws FileNotFoundException {

        VehicleFactory factory = new VehicleFactory();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        int lineNumber = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            // Makes vehicle only if line is not blank
            if(line.length() > 0) {
                System.out.println("line " + lineNumber + ": " + line);
                Vehicle myVehicle = factory.getVehicle(line);
                System.out.println(myVehicle.getClass());
                vehicleList.add(myVehicle);
            }

            lineNumber++;
        }
//        System.out.println(vehicleList.size());
    }
    public double getTotalProfit() {
        for (int i = 0; i < vehicleList.size(); i++) {
            // TODO: Need to add condition to check for parking lot capacity
            totalProfit += dollarPerHour * vehicleList.get(i).getTime();
        }
        return totalProfit;
    }
}