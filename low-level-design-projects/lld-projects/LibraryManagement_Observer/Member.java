public class Member implements LibraryObserver {
    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public void onBookAvailable(Book book) {
        System.out.println("[Notification to " + name + "] '" + book.getTitle() + "' is available now!");
    }
}
