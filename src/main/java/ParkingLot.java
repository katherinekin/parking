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

    public void setRate(double rate) {
        this.dollarPerHour = rate;
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
        System.out.printf("handicap occupied: %d out of %d\n", this.handicapContainer.getOccupiedSpace(), this.handicapContainer.length);
        System.out.printf("moped occupied: %d out of %d\n", this.mopedContainer.getOccupiedSpace(), this.mopedContainer.length);
        System.out.printf("other occupied: %d out of %d\n", this.otherContainer.getOccupiedSpace(), this.otherContainer.length);
        System.out.printf("total profit for %f dollars per hour: %f\n", this.dollarPerHour, this.getTotalProfit());
    }
}