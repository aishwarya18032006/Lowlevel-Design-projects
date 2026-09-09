# Parking Lot System

**Patterns:** Singleton (`ParkingLot`), Strategy (`FeeStrategy`)
**SOLID:** Single Responsibility (each class owns one concern), Open/Closed
(new fee models or vehicle types can be added without changing `ParkingLot`)

## Design
- `Vehicle` — enum of vehicle types (MOTORCYCLE, CAR, TRUCK)
- `ParkingSpot` — a single spot; knows its type and occupancy
- `FeeStrategy` (interface) — `calculateFee(hours)`
  - `HourlyFeeStrategy`, `FlatRateFeeStrategy` — interchangeable pricing rules
- `ParkingLot` — Singleton; owns all spots, assigns/frees them, delegates fee
  calculation to whichever `FeeStrategy` it's configured with

## Run
```
cd ParkingLot_StrategySingleton
javac *.java
java Main
```
