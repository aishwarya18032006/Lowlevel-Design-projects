// Observer pattern: Library (subject) notifies observers without knowing their concrete type
public interface LibraryObserver {
    void onBookAvailable(Book book);
}
