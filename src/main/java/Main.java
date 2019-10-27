import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
// read the text file


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String homePath = "./src/main/resources/";
        Scanner scanner;

        // TODO: Add these to JUnit tests for part 2
        // Only first two cars should park, not enough room for all cars
        String filePath = String.valueOf(Paths.get(homePath + "input1.txt"));
        CarParker carParker = new CarParker();
        carParker.setVehicleList(filePath);

        ParkingLot parkingLot = new ParkingLot(2,2,2);
        parkingLot.setVehicleList(filePath);
        System.out.printf("Total profit: %f\n\n", parkingLot.getTotalProfit());

//        // All cars should be able to park
//        filePath = String.valueOf(Paths.get(homePath + "input2.txt"));
//        parkingLot = new ParkingLot(2,2,2);
//        parkingLot.setVehicleList(filePath);
//        System.out.printf("Total profit: %f\n\n", parkingLot.getTotalProfit());
//
//        // All cars should be able to park
//        filePath = String.valueOf(Paths.get(homePath + "input3.txt"));
//        parkingLot = new ParkingLot(2,2,2);
//        parkingLot.setVehicleList(filePath);
//        System.out.printf("Total profit: %f\n\n", parkingLot.getTotalProfit());
//
//        // One vehicle should not be able to park (third vehicle) due to lack of space
//        filePath = String.valueOf(Paths.get(homePath + "input4.txt"));
//        parkingLot = new ParkingLot(2,2,2);
//        parkingLot.setVehicleList(filePath);
//        System.out.printf("Total profit: %f\n\n", parkingLot.getTotalProfit());
//
//        // Invalid input, profit should be 0
//        filePath = String.valueOf(Paths.get(homePath + "input5.txt"));
//        parkingLot = new ParkingLot(2,2,2);
//        parkingLot.setVehicleList(filePath);
//        System.out.printf("Total profit: %f\n\n", parkingLot.getTotalProfit());
    }
}
