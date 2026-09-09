# Low-Level Design Projects

Object-oriented system designs implemented in Java, applying SOLID principles
and classic Gang-of-Four design patterns.

| Project | Patterns Used | Folder |
|---|---|---|
| Parking Lot | Singleton, Strategy | `ParkingLot_StrategySingleton/` |
| Tic-Tac-Toe | Factory, Observer | `TicTacToe_FactoryObserver/` |
| Library Management | Observer | `LibraryManagement_Observer/` |

Each folder has its own README with the class design and how to run it.

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
# Tic-Tac-Toe

**Patterns:** Factory (`PlayerFactory`), Observer (`GameObserver`)
**SOLID:** Open/Closed (new player types or observers plug in without
modifying `Game`), Interface Segregation (`Player`, `GameObserver` are thin
interfaces)

## Design
- `Player` (abstract) — `HumanPlayer`, `ComputerPlayer` (random-move AI)
- `PlayerFactory` — creates the right `Player` subtype from a type string
- `Board` — 3x3 grid, move validation, win/draw checking
- `GameObserver` (interface) — `onMove()`, `onGameEnd()`
  - `ScoreBoardObserver` — tracks and prints running win/draw counts
- `Game` — runs turns, notifies all registered observers of every move and
  the final result

## Run
```
cd TicTacToe_FactoryObserver
javac *.java
java Main
```
# Library Management System

**Patterns:** Observer (`LibraryObserver`)
**SOLID:** Single Responsibility (`Book`, `Member`, `Library` each own one
job), Dependency Inversion (`Library` depends on the `LibraryObserver`
interface, not on concrete `Member` classes)

## Design
- `Book` — title, author, availability
- `Member` implements `LibraryObserver` — gets notified when a book they're
  waiting on becomes available again
- `LibraryObserver` (interface) — `onBookAvailable(Book)`
- `Library` (subject) — holds the catalog, manages borrow/return, maintains a
  waitlist per book and notifies waiting members automatically on return

## Run
```
cd LibraryManagement_Observer
javac *.java
java Main
```
