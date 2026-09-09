public class ParkingSpot {
    private final int spotId;
    private final Vehicle.Type spotType;
    private Vehicle parkedVehicle;
    private long entryTimeMillis;

    public ParkingSpot(int spotId, Vehicle.Type spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean fits(Vehicle vehicle) {
        return spotType == vehicle.getType();
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.entryTimeMillis = System.currentTimeMillis();
    }

    public Vehicle removeVehicle() {
        Vehicle v = this.parkedVehicle;
        this.parkedVehicle = null;
        return v;
    }

    public long getParkedDurationHours() {
        long durationMillis = System.currentTimeMillis() - entryTimeMillis;
        return Math.max(1, durationMillis / (1000 * 60 * 60));
    }

    public int getSpotId() { return spotId; }
    public Vehicle.Type getSpotType() { return spotType; }
}
