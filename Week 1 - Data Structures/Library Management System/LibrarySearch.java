import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {
    public static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public static Book binarySearch(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase())); // case-insensitive sort
        title = title.toLowerCase();
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.toLowerCase().compareTo(title);

            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "Inferno", "Dan Brown"),
            new Book(103, "1984", "George Orwell"),
            new Book(104, "The Hobbit", "J.R.R. Tolkien"),
            new Book(105, "Animal Farm", "George Orwell")
        };

        System.out.println("=== Linear Search ===");
        Book foundLinear = linearSearch(books, "The Hobbit");
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Book not found.");

        System.out.println("\n=== Binary Search ===");
        Book foundBinary = binarySearch(books, "The Hobbit");
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Book not found.");

        System.out.println("\n=== Analysis ===");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n) (only on sorted data)");
        System.out.println("Use Linear Search for small/unsorted datasets or single search.");
        System.out.println("Use Binary Search for large, sorted datasets with frequent searches.");
    }
}
