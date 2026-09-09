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
