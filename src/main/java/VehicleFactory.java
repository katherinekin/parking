public class VehicleFactory {
    public Vehicle getVehicle(String line) {
        try {
            String[] carInfo = line.trim().split("\\s+");
            switch (carInfo[0].toLowerCase()) {
                case "handicap":
                    return new Handicap(carInfo[1], Integer.parseInt(carInfo[2]));
                case "moped":
                    return new Moped(carInfo[1], Integer.parseInt(carInfo[2]));
                case "truck":
                    return new Truck(carInfo[1], Integer.parseInt(carInfo[2]));
                default:
                    return new Car(carInfo[1], Integer.parseInt(carInfo[2]));
            }
        } catch (Exception e) {
            System.out.println("An invalid vehicle has entered the parking lot!");
//            e.printStackTrace();
            return new Car("", 0);
        }
    }
}