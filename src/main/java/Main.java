import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String homePath = "./src/main/resources/";
        CarParker carParker = new CarParker();

        // First two cars should park in cheapest lot, last car should park in second cheapest lot
        String filePath = String.valueOf(Paths.get(homePath + "input1.txt"));
        carParker.createGroup("GroupA", 1.0, 2,2,2);
        carParker.createGroup("GroupB", 3.0, 2,2,2);
        carParker.createGroup("GroupC", 2.0, 2,2,2);
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // All vehicles should be able to park in first lot
        filePath = String.valueOf(Paths.get(homePath + "input2.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // All vehicles should be able to park in first lot, which is now full
        filePath = String.valueOf(Paths.get(homePath + "input3.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // One vehicle will need to park in second lot
        filePath = String.valueOf(Paths.get(homePath + "input4.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // Invalid input, profit should be 0
        filePath = String.valueOf(Paths.get(homePath + "input5.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // One vehicle will not be able to park, only one parking lot
        filePath = String.valueOf(Paths.get(homePath + "input4.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
    }
}
