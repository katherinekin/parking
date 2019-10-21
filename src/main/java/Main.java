import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
// read the text file


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String homePath = "./src/main/resources/";
        Scanner scanner;

        //creating File instance to reference text file in Java
        String filePath = String.valueOf(Paths.get(homePath + "input1.txt"));
        ParkingLot parkingLot = new ParkingLot(2,2,2);
        parkingLot.setVehicleList(filePath);
        System.out.println(parkingLot.getTotalProfit());
//        System.out.printf("Parking lot size is %d.", parkingLot.getCapacity());
    }
}
