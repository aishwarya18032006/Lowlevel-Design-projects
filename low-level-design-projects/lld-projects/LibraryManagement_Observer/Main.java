public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book("ISBN-001", "Clean Code", "Robert C. Martin");
        library.addBook(book);

        Member aish = new Member("Aish");
        Member priya = new Member("Priya");

        library.borrowBook("ISBN-001", aish);   // succeeds
        library.borrowBook("ISBN-001", priya);  // unavailable -> waitlisted

        library.returnBook("ISBN-001");         // Priya gets auto-notified
    }
}
