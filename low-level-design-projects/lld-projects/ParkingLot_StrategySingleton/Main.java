public class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(); // same instance everywhere

        Vehicle car1 = new Vehicle("TN-01-CAR-1", Vehicle.Type.CAR);
        Vehicle bike1 = new Vehicle("TN-01-BIKE-1", Vehicle.Type.MOTORCYCLE);

        ParkingSpot carSpot = lot.parkVehicle(car1);
        lot.parkVehicle(bike1);

        // switch pricing strategy at runtime without touching ParkingLot's code
        lot.setFeeStrategy(new FlatRateFeeStrategy());
        lot.unparkVehicle(carSpot);
    }
}
