package com.poc.graphql.service;

import com.poc.graphql.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService implements IBookService {

    private static final Set<Book> BOOKS_DATA = initializeData();

    @Override
    public Book getBookWithTitle(String title) {
        return BOOKS_DATA.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(BOOKS_DATA);
    }

    @Override
    public Book addBook(Book book) {
        BOOKS_DATA.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        BOOKS_DATA.removeIf(b -> Objects.equals(b.getId(), book.getId()));
        BOOKS_DATA.add(book);
        return book;
    }

    @Override
    public boolean deleteBook(Book book) {
        return BOOKS_DATA.remove(book);
    }

    private static Set<Book> initializeData() {
        Book book1 = new Book(1, "J. R. R. Tolkien", "The Lord of the Rings");
        Book book2 = new Book(2, "Graham", "The Intelligent Investor");
        Book book3 = new Book(3, "Seth Godin", "The DIP");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }
}
