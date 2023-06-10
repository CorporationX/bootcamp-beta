package ru.faang.school.hashmap.task_2;


import ru.faang.school.hashmap.task_2.book.Book;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        addBook("Mark", "Maks", 2023, "1");
        addBook("Lex", "Lexa", 2022, "2");

        deleteBook("Mark", "Maks", 2023);
        bookAll();

        System.out.println(searchBook("Mark", "Maks", 2023));
        System.out.println(searchBook("Lex", "Lexa", 2022));
    }

    private static void addBook(String title, String author, int year, String numberPolk) {
        books.put(new Book(title, author, year), numberPolk);
    }

    private static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    private static String searchBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            return books.get(book);
        }
        return "book net!!";
    }

    private static void bookAll() {
        books.forEach((key, value) -> System.out.println(key.toString() + " полка: " + value));
    }
}
