import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;

    @Override
    public String toString() {
        return "ID: " + id + ", Название: " + title + ", Автор: " + author;
    }
}