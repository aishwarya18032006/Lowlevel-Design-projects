import java.util.ArrayList;
import java.util.List;

// Singleton pattern: exactly one ParkingLot instance manages all spots
public class ParkingLot {
    private static ParkingLot instance;

    private final List<ParkingSpot> spots = new ArrayList<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        // pre-populate spots
        for (int i = 1; i <= 3; i++) spots.add(new ParkingSpot(i, Vehicle.Type.MOTORCYCLE));
        for (int i = 4; i <= 8; i++) spots.add(new ParkingSpot(i, Vehicle.Type.CAR));
        for (int i = 9; i <= 10; i++) spots.add(new ParkingSpot(i, Vehicle.Type.TRUCK));
        this.feeStrategy = new HourlyFeeStrategy(); // default strategy
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.fits(vehicle)) {
                spot.parkVehicle(vehicle);
                System.out.println("Parked " + vehicle.getLicensePlate() + " at spot " + spot.getSpotId());
                return spot;
            }
        }
        System.out.println("No available spot for " + vehicle.getLicensePlate());
        return null;
    }

    public double unparkVehicle(ParkingSpot spot) {
        long hours = spot.getParkedDurationHours();
        double fee = feeStrategy.calculateFee(hours);
        Vehicle v = spot.removeVehicle();
        System.out.println("Vehicle " + v.getLicensePlate() + " left after " + hours + " hr(s). Fee: " + fee);
        return fee;
    }
}
