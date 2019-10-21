import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;


public class ParkingLot {
    private int totalCapacity = 0;
    private int handicapCapacity = 0;
    private int compactCapacity = 0;
    private int otherCapacity = 0;

    // If car arrives, check for open spots based on type
//    private Map<Vehicle, Integer> takenSpaces = new HashMap<Vehicle, Integer>();

    // Keeps track of all cars read from file
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    // When gate is true, the gate is unoccupied
    private boolean entryGate = true;
    private boolean exitGate = true;
    private double dollarPerHour = 2.0;  // charge each car per hour
    private double totalProfit = 0.0;


    // Constructor
    ParkingLot(int handicap, int compact, int other) {
        this.handicapCapacity = handicap;
        this.compactCapacity = compact;
        this.otherCapacity = other;
        this.totalCapacity = handicap + compact + other;
    }

//    public LocalDateTime getCurrentTime () {
//        return LocalDateTime.now();
//    }

//    public Boolean isFull() {
//        if (takenSpaces.size() <= capacity) {
//            return true;
//        }
//        return false;
//    }
    public int getCapacity() {
        return totalCapacity;
    }
//    public int getParkingSpace(Car car) {
//        return takenSpaces.get(car);
//    }

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
        Vehicle currVehicle;
        for (int i = 0; i < vehicleList.size(); i++) {
            currVehicle = vehicleList.get(i);
            // TODO: Need to add condition to check for parking lot capacity
            // If there are still spots available
            if (this.totalCapacity > 0 ) {
                if (currVehicle.getType() == "handicap" && this.handicapCapacity > 0) {
                    this.handicapCapacity--;
                    totalProfit += dollarPerHour * currVehicle.getTime();
                }
                else if (currVehicle.getType() == "truck" && this.otherCapacity > 0) {
                    this.otherCapacity--;
                    totalProfit += dollarPerHour * currVehicle.getTime();
                }
                else {
                    if (this.otherCapacity > 0) {
                        this.otherCapacity--;
                        totalProfit += dollarPerHour * currVehicle.getTime();
                    }
                    else if (this.compactCapacity > 0){
                        this.compactCapacity--;
                        totalProfit += dollarPerHour * currVehicle.getTime();
                    }
                }
            }
            this.totalCapacity = this.handicapCapacity + this.compactCapacity + this.otherCapacity;
        }
        System.out.printf("handicapCapacity: %d\n", this.handicapCapacity);
        System.out.printf("compactCapacity: %d\n", this.compactCapacity);
        System.out.printf("otherCapacity: %d\n", this.otherCapacity);

        return totalProfit;
    }
}