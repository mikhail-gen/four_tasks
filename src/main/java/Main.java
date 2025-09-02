import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Показать все книги");
            System.out.println("3. Найти книгу по ID");
            System.out.println("4. Удалить книгу по ID");
            System.out.println("5. Выход");
            System.out.print("Выберите опцию: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    Book book = library.addBook(title, author);
                    System.out.println("Книга добавлена: " + book);
                    break;

                case "2":
                    System.out.println("Список книг:");
                    for (Book b : library.getAllBooks()) {
                        System.out.println(b);
                    }
                    break;

                case "3":
                    System.out.print("Введите ID книги: ");
                    int idToFind = Integer.parseInt(scanner.nextLine());
                    Book foundBook = library.getBookById(idToFind);
                    if (foundBook != null) {
                        System.out.println("Найдена книга: " + foundBook);
                    } else {
                        System.out.println("Книга не найдена.");
                    }
                    break;

                case "4":
                    System.out.print("Введите ID книги для удаления: ");
                    int idToDelete = Integer.parseInt(scanner.nextLine());
                    boolean deleted = library.deleteBook(idToDelete);
                    if (deleted) {
                        System.out.println("Книга удалена.");
                    } else {
                        System.out.println("Книга не найдена.");
                    }
                    break;

                case "5":
                    running = false;
                    System.out.println("Выход...");
                    break;

                default:
                    System.out.println("Неверная команда.");
            }
        }

        scanner.close();
    }
}