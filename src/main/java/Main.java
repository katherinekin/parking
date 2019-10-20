import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
// read the text file


public class Main {
    public static Vehicle makeVehicle(String line) {
        try {
            String[] carInfo = line.trim().split("\\s+");
            switch(carInfo[0].toLowerCase()) {
                case "moped":
                    return new Moped(carInfo[1], Integer.parseInt(carInfo[2]));
                case "truck":
                    return new Truck(carInfo[1], Integer.parseInt(carInfo[2]));
                default:
                    return new Car(carInfo[1], Integer.parseInt(carInfo[2]));
            }
        } catch (Exception e){
            System.out.println("An invalid vehicle has entered the parking lot!");
            e.printStackTrace();
            return new Car("", 0);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String homePath = "./src/main/resources/";
        Scanner scanner;

        //creating File instance to reference text file in Java
        File file = new File(String.valueOf(Paths.get(homePath + "input1.txt")));
        scanner = new Scanner(file);

        int lineNumber = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            // Makes vehicle only if line is not blank
            if(line.length() > 0) {
                System.out.println("line " + lineNumber + ": " + line);
                Vehicle myVehicle = makeVehicle(line);
                System.out.println(myVehicle.getClass());
            }

            lineNumber++;
        }
//        ParkingLot parkingLot = new ParkingLot();
//        System.out.printf("Parking lot size is %d.", parkingLot.getCapacity());
    }
}
