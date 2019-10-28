import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String homePath = "./src/main/resources/";
        CarParker carParker = new CarParker();

        // First two cars should park in cheapest lot, last car should park in second cheapest lot
        String filePath = String.valueOf(Paths.get(homePath + "input1.txt"));
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // All cars should be able to park
        filePath = String.valueOf(Paths.get(homePath + "input2.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // All cars should be able to park
        filePath = String.valueOf(Paths.get(homePath + "input3.txt"));
        carParker = new CarParker();
        carParker.createGroup("GroupA", 1.0, 2,2,2); // creates one group
        carParker.createGroup("GroupB", 3.0, 2,2,2); // creates one group
        carParker.createGroup("GroupC", 2.0, 2,2,2); // creates one group
        carParker.setVehicleList(filePath);
        carParker.parkAllVehicles();
        carParker.displayParkingLots();
        System.out.println();

        // All cars should be able to park
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
    }
}
