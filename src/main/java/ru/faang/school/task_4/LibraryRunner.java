package ru.faang.school.task_4;


public class LibraryRunner {

    public static void main(String[] args) {
        Book book1 = new Book("It", "King", 2002);
        Book book2 = new Book("War and peace", "Tolstoy", 2003);
        Book book3 = new Book("Romeo and Juliet", "Shakespeare", 2004);
        Book book4 = new Book("Black Tower", "King", 2005);
        Book book5 = new Book("Black Tower", "King", 2005);

        Library library = new Library(0);
        library.addBook(book1,1);
        library.addBook(book2,2);
        library.addBook(book3,3 );
        library.addBook(book4,5 );
        library.addBook(book5,6);


        library.printLibraryBooks();
        System.out.println(library.getBookShelfNumber(book1));
        System.out.println(library.getBookShelfByTitle("Black Tower"));
        System.out.println(library.getBookShelfByAuthorAndYear("King", 2002));

        library.removeBook(book1);
        library.removeBookByTitle("War and peace");
        library.removeBookByAuthorAndYear("King", 2005);
        System.out.println();
        library.printLibraryBooks();
    }
}
