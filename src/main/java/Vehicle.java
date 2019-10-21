import java.time.LocalDateTime;

class Vehicle {
    protected String type;
    private String license;
    private int time = 0;
    Vehicle(String license, int time) {
        this.license = license;
        this.time = time;
    }
    public int getTime() {
        return this.time;
    }
    public String getType() { return this.type; }
    public String getLicense() { return this.license; }
    public void displayVehicle() {
        System.out.printf("Type: %s, License %s, Hours %d", this.type, this.license, this.time);
    }
}

class Car extends Vehicle {
    Car(String license, int time) {
        super(license, time);
        this.type = "car";
    }
}
class Moped extends Vehicle {
    Moped(String license, int time) {
        super(license, time);
        this.type = "moped";
    }
}

class Truck extends Vehicle {
    Truck(String license, int time) {
        super(license, time);
        this.type = "truck";
    }
}

class Handicap extends Car {
    Handicap(String license, int time) {
        super(license, time);
        this.type = "handicap";
    }
}
