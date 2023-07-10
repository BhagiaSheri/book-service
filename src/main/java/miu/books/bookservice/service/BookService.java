package miu.books.bookservice.service;

import miu.books.bookservice.domain.Book;
import miu.books.bookservice.integration.JmsSender;
import miu.books.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private JmsSender jmsSender;

    @Autowired
    public BookService(BookRepository bookRepository, JmsSender jmsSender) {
        this.bookRepository = bookRepository;
        this.jmsSender = jmsSender;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
        jmsSender.sendMessage(book);
    }

    public void updateBook(String isbn, Book book) {
        bookRepository.save(book);
        jmsSender.sendMessage(book);
    }

    public void deleteBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        bookRepository.delete(isbn);
        jmsSender.sendMessage(book);
    }

    public Book getBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
