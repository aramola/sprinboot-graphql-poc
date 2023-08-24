package com.poc.graphql.service;

import com.poc.graphql.model.Book;

import java.util.List;

public interface IBookService {
    Book getBookWithTitle(String title);

    List<Book> getAllBooks();

    Book addBook(Book book);

    Book updateBook(Book book);

    boolean deleteBook(Book book);
}
