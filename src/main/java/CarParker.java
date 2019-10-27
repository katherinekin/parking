import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarParker {

    // Keeps track of all cars read from file
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private List<Group> groupList = new ArrayList<Group>();

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
    public void createGroup(String name, int handicap, int moped, int other) {
        Group newGroup = new Group(name, handicap, moped, other);
        groupList.add(newGroup);
    }
    // First check price, then check capacity (assume car can check type of parkingspot), then try to park the car
    public void parkAllVehicles() {
        
    }

}
