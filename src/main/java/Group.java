public class Group {
    public String name = "";
    private double price = 1.0; // Rate in dollars per hour
    private double discount = 0.0;  // Between 0 and 1, percent off
    private String policy = "";
    public ParkingLot parkingLot;


    Group(String name, double price, int handicap, int moped, int other) {
        this.name = name;
        this.price = price;
        this.parkingLot = new ParkingLot(handicap, moped, other);
        this.parkingLot.setRate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void displayParkingLot() {
        System.out.printf("Group: %s\n", this.name);
        parkingLot.displayParkingLot();
    }
}
