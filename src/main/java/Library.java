import java.util.*;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private int nextId = 1;
    private PriorityQueue<Integer> availableIds = new PriorityQueue<>();

    public Book addBook(String title, String author) {
        int id;
        if (!availableIds.isEmpty()) {
            id = availableIds.poll();
        } else {
            id = nextId++;
        }
        Book book = new Book(id, title, author);
        books.put(id, book);
        return book;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public boolean deleteBook(int id) {
        if (books.remove(id) != null) {
            availableIds.offer(id);
            return true;
        }
        return false;
    }
}