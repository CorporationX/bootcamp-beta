package ru.faang.school.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Library {

    private int shelfQuantity;

    private Map<Book, Integer> books = new HashMap<>();

    public Library(int shelfQuantity) {
        if (shelfQuantity > 0 && shelfQuantity < 25) {
            this.shelfQuantity = shelfQuantity;
        } else {
            System.out.println("Quantity of the shelves should be more than 0 or less then 25");
        }
    }

    public void addBook(Book book, int shelfNumber) {
        if (shelfNumber <= shelfQuantity) {
            books.put(book, shelfNumber);
        }
    }

    public int getBookShelfNumber(Book book) {
        return books.get(book);
    }

    public void removeBook(Book book) {
        if (books.containsKey(book)) {
            books.remove(book);
        } else {
            throw new IllegalArgumentException("Library does not contains this book");
        }
    }

    public void removeBookByTitle(String bookTitle) {
        books.entrySet().removeIf(entry ->
                entry.getKey().getTitle().equals(bookTitle));
    }

    public void removeBookByAuthorAndYear(String author, int year) {
        books.entrySet().removeIf(entry ->
                (entry.getKey().getAuthor().equals(author) && (entry.getKey().getYear() == year))
        );
    }

    public int getBookShelfByTitle(String title) {
        Optional<Integer> shelfNumber = books.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getTitle().equals(title))
                .map(Map.Entry::getValue)
                .findFirst();

        return shelfNumber.orElse(-1);
    }

    public int getBookShelfByAuthorAndYear(String author, int year) {
        Optional<Integer> shelfNumber = books.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getAuthor().equals(author) && entry.getKey().getYear() == year)
                .map(Map.Entry::getValue)
                .findFirst();

        return shelfNumber.orElse(-1);
    }

    public void printLibraryBooks() {
        books.forEach((book, shelfNumber) -> System.out.println(book + " on the shelf №" + shelfNumber));
    }
}