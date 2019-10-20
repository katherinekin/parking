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
        File file = new File(String.valueOf(Paths.get(homePath + "input1.txt")));
        scanner = new Scanner(file);

        int lineNumber = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            // Makes vehicle only if line is not blank
            if(line.length() > 0)
                System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
        }
//        ParkingLot parkingLot = new ParkingLot();
//        System.out.printf("Parking lot size is %d.", parkingLot.getCapacity());
    }
}
