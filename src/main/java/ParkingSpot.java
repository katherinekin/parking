class ParkingSpot {
    public String lotID;
    public String type;
    ParkingSpot (String id) {
        this.lotID = id;
    }
}

class HandicapSpot extends ParkingSpot {
    HandicapSpot(String id) {
        super(id);
        this.type = "handicap";
    }
}

class CompactSpot extends ParkingSpot {
    CompactSpot(String id) {
        super(id);
        this.type = "compact";
    }
}

class OtherSpot extends ParkingSpot {
    OtherSpot(String id) {
        super(id);
        this.type = "default";
    }
}