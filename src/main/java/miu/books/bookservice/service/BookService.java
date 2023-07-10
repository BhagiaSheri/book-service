package miu.books.bookservice.service;

import miu.books.bookservice.domain.Book;
import miu.books.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(String isbn, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.delete(isbn);
    }

    public Book getBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream().toList();
    }
}
