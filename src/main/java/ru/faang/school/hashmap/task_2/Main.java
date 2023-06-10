package ru.faang.school.hashmap.task_2;

import java.util.HashMap;

public class Main {
    private static final HashMap<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Book1", "Author1", 2000);
        Book book2 = new Book("Book2", "Author2", 2005);
        Book book3 = new Book("Book3", "Author3", 2010);
        Book book4 = new Book("Book4", "Author4", 2015);

        addNewBook(book1, "Shelf1");
        addNewBook(book2, "Shelf2");
        addNewBook(book3, "Shelf3");
        addNewBook(book4, "Shelf4");
        printLibrary(LIBRARY);

        removeBook("Book2", "Author2", 2005);
        printLibrary(LIBRARY);

        findBook("Book1", "Author1", 2000);
        printLibrary(LIBRARY);

    }


    private static void addNewBook(Book book, String location) {
        LIBRARY.put(book, location);
    }

    private static void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        LIBRARY.remove(bookToRemove);
    }

    private static void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = LIBRARY.get(bookToFind);

        if (location != null) {
            System.out.println("Book found. Location: " + location);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private static void printLibrary(HashMap<Book, String> library) {
        for (var entry : library.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Year: " + book.getYear() + ", Location: " + location);
        }
        System.out.println();
    }
}
