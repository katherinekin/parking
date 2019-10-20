class ParkingLotSpace {
    public String lotID;
    public String type;
    ParkingLotSpace (String id) {
        this.lotID = id;
    }
}

class HandicapSpace extends ParkingLotSpace {
    HandicapSpace(String id) {
        super(id);
        this.type = "handicap";
    }
}

class CompactSpace extends ParkingLotSpace {
    CompactSpace(String id) {
        super(id);
        this.type = "compact";
    }
}

class DefaultSpace extends ParkingLotSpace {
    DefaultSpace(String id) {
        super(id);
        this.type = "default";
    }
}