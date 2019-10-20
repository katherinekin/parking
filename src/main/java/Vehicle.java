import java.time.LocalDateTime;

abstract class Vehicle {
    private String type;
    private String license;
    private String time;
}

class Car extends Vehicle {

}
class Moped extends Vehicle {}

class Truck extends Vehicle {}
