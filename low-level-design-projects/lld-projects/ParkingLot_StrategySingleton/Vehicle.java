public class Vehicle {
    public enum Type { MOTORCYCLE, CAR, TRUCK }

    private final String licensePlate;
    private final Type type;

    public Vehicle(String licensePlate, Type type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() { return licensePlate; }
    public Type getType() { return type; }
}
