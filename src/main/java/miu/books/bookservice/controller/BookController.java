package miu.books.bookservice.controller;

import miu.books.bookservice.domain.Book;
import miu.books.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void addBook(@RequestBody Book book){
       bookService.addBook(book);
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{isbn}")
    public void updateBook(@PathVariable String isbn, @RequestBody Book book){
        bookService.updateBook(isbn, book);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn){
        bookService.deleteBook(isbn);
    }

    @ResponseStatus(OK)
    @GetMapping("/{isbn}")
    public Book getBook(@PathVariable String isbn){
      return  bookService.getBook(isbn);
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }

}
