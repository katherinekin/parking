import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CarParker {

    // Keeps track of all cars read from file
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    public List<Group> groupList = new ArrayList<Group>();


    public void setVehicleList(String filename) throws FileNotFoundException {

        VehicleFactory factory = new VehicleFactory();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        vehicleList = new ArrayList<Vehicle>();

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
            }
            lineNumber++;
        }
    }
    public void createGroup(String name, double price, int handicap, int moped, int other) {
        Group newGroup = new Group(name, price, handicap, moped, other);
        groupList.add(newGroup);
    }
    // First check price, then check capacity (assume car can check type of parkingspot), then try to park the car
    public void parkAllVehicles() {
        Collections.sort(this.groupList, Comparator.comparingDouble(Group::getPrice));  // Sort list in ascending order

        Vehicle currVehicle;

        for (int i = 0; i < vehicleList.size(); i++) {
            currVehicle = vehicleList.get(i);
            for (int j = 0; j < groupList.size(); j++) {
                Group currGroup = groupList.get(j);
                if (currGroup.parkingLot.getTotalFreeSpace() > 0)
                    if (currGroup.parkingLot.parkVehicle(currVehicle)) // tries to park vehicle, if successful break
                        break;
            }
        }
    }

    public void displayParkingLots() {
        for (Group group : groupList) {
            group.displayParkingLot();
        }
    }
}
