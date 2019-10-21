public class ParkingSpotContainer {

    private int index = 0;
    public int length = 0;
    private Vehicle[] parkingSpotContainer;

    ParkingSpotContainer(int capacity) {
        this.length = capacity;
        this.index = 0;
        this.parkingSpotContainer = new Vehicle[capacity];
    }

    public void park(Vehicle vehicle) {
        this.parkingSpotContainer[this.index] = vehicle;
        this.index++;
    }

    public Vehicle get(int idx) {
        return this.parkingSpotContainer[idx];
    }

    public int getIndex() {
        return this.index;
    }

    public int getFreeSpace() {
        return this.length - this.index;
    }
}
