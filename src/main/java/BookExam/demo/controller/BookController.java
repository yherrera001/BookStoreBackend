package BookExam.demo.controller;

import BookExam.demo.pojo.Books;
import BookExam.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Books> getAllBooks(){
        return bookService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public Books addBook(@RequestBody Books bookType){
        return bookService.addBook(bookType);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books/{bookId}")
    public void updateBook(@PathVariable Long bookId, @RequestBody Books book){
        bookService.updateBook(book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/book/{id}")
    public void deleteBookByID(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/book/{id}")
    public Books getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/title")
    public List<Books> getBookByTitle(@RequestParam(name = "title") String title){
        return bookService.getBookByName(title);
    }
}
