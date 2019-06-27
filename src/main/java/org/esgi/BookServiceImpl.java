package org.esgi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookServiceImpl implements BookService {

    private List<Book> books = createBooks();

    private List<Book> createBooks() {
        return new ArrayList<>(Arrays.asList(new Book(1, "Vernon Subutex"), new Book(2, "Harry Potter"), new Book(3, "1984")));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book findById(int id) {
        return books.stream().filter( a -> a.getId()==id).findFirst().orElseThrow(RuntimeException::new);
    }
}
