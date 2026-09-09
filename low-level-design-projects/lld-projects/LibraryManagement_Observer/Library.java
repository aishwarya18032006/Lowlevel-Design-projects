import java.util.*;

public class Library {
    private final Map<String, Book> catalog = new HashMap<>();
    private final Map<String, List<LibraryObserver>> waitlists = new HashMap<>();

    public void addBook(Book book) {
        catalog.put(book.getIsbn(), book);
    }

    public boolean borrowBook(String isbn, Member member) {
        Book book = catalog.get(isbn);
        if (book == null || !book.isAvailable()) {
            System.out.println(member.getName() + " could not borrow (unavailable). Adding to waitlist.");
            waitlists.computeIfAbsent(isbn, k -> new ArrayList<>()).add(member);
            return false;
        }
        book.setAvailable(false);
        System.out.println(member.getName() + " borrowed " + book);
        return true;
    }

    public void returnBook(String isbn) {
        Book book = catalog.get(isbn);
        if (book == null) return;
        book.setAvailable(true);
        System.out.println(book.getTitle() + " was returned.");

        // Observer pattern: notify every waiting member, then clear the waitlist
        List<LibraryObserver> waiting = waitlists.getOrDefault(isbn, Collections.emptyList());
        for (LibraryObserver observer : waiting) {
            observer.onBookAvailable(book);
        }
        waiting.clear();
    }
}
