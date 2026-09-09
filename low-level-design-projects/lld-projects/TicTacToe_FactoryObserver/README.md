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
