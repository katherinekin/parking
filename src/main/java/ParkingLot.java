import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ParkingLot {
    private int totalCapacity = 0;

    private ParkingSpotContainer handicapContainer; // capacity initialized to 0
    private ParkingSpotContainer mopedContainer;  // for mopeds only
    private ParkingSpotContainer otherContainer;    // for everyone else

    // Gates
    private int entryGate = 1;
    private int exitGate = 1;

    // If car arrives, check for open spots based on type
    // Keeps track of all cars read from file
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    // When gate is true, the gate is unoccupied

    private double dollarPerHour = 1.0;  // charge each car per hour
    private double totalProfit = 0.0;

    // Constructor
    ParkingLot(int handicap, int moped, int other) {
        this.handicapContainer = new ParkingSpotContainer(handicap);
        this.mopedContainer = new ParkingSpotContainer(moped);
        this.otherContainer = new ParkingSpotContainer(other);  // trucks, cars
        this.totalCapacity = handicap + moped + other;
    }

    public int getCapacity() {
        return this.totalCapacity;
    }
    public void setRate(double rate) {
        this.dollarPerHour = rate;
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
                // check if vehicle is valid
                if (myVehicle.getLicense().length() > 0)
                    vehicleList.add(myVehicle);
//                System.out.println(myVehicle.getClass());
            }
            lineNumber++;
        }
    }

    // Check for empty lots
    public void parkVehicle() {
        Vehicle currVehicle;
        for (int i = 0; i < vehicleList.size(); i++) {
            currVehicle = vehicleList.get(i);
            if (this.totalCapacity > 0) {
                if (currVehicle.getType().equals("handicap")
                        && this.handicapContainer.getIndex() < this.handicapContainer.length) {
                    this.handicapContainer.park(currVehicle);
                    this.totalCapacity--;
                }
                else if (currVehicle.getType().equals("moped")
                        && this.mopedContainer.getIndex() < this.mopedContainer.length) {
                    this.mopedContainer.park(currVehicle);
                    this.totalCapacity--;
                }
                else {
                    if (this.otherContainer.getFreeSpace() > 0) {
                        this.otherContainer.park(currVehicle);
                        this.totalCapacity--;
                    }
                }
            }
        }
    }
    public boolean parkVehicle(Vehicle currVehicle) {

        if (this.totalCapacity > 0) {
            if (currVehicle.getType().equals("handicap")
                    && this.handicapContainer.getIndex() < this.handicapContainer.length) {
                this.handicapContainer.park(currVehicle);
                this.totalCapacity--;
                return true;
            }
            else if (currVehicle.getType().equals("moped")
                    && this.mopedContainer.getIndex() < this.mopedContainer.length) {
                this.mopedContainer.park(currVehicle);
                this.totalCapacity--;
                return true;
            }
            else {
                if (this.otherContainer.getFreeSpace() > 0) {
                    this.otherContainer.park(currVehicle);
                    this.totalCapacity--;
                    return true;
                }
            }
        }
        return false;
    }

    // Check if entryGate is unoccupied
    public int getTotalFreeSpace() {
        return handicapContainer.getFreeSpace() + mopedContainer.getFreeSpace() + otherContainer.getFreeSpace();
    }

    public double getTotalProfit() {
        // Park vehicles first
        parkVehicle();
        // Set container for all parkingSpotContainers to iterate through
        List<ParkingSpotContainer> parkingLot = List.of(
                this.handicapContainer,
                this.mopedContainer,
                this.otherContainer
        );
        for (ParkingSpotContainer parkingSpotContainer : parkingLot) {
            for (int j = 0; j < parkingSpotContainer.getIndex(); j++) {
                if (parkingSpotContainer.get(j) != null)
                    totalProfit += dollarPerHour * parkingSpotContainer.get(j).getTime();
            }
        }

        return totalProfit;
    }

    public void displayParkingLot() {
        System.out.println("Parking lot occupancy:");
        System.out.printf("handicapCapacity: %d out of %d\n", this.handicapContainer.getFreeSpace(), this.handicapContainer.length);
        System.out.printf("mopedCapacity: %d out of %d\n", this.mopedContainer.getFreeSpace(), this.mopedContainer.length);
        System.out.printf("otherCapacity: %d out of %d\n", this.otherContainer.getFreeSpace(), this.otherContainer.length);
    }
}