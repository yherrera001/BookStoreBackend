package BookExam.demo.service;

import BookExam.demo.controller.BookController;
import BookExam.demo.pojo.Books;
import BookExam.demo.repo.BooksRepo;
import BookExam.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class BookService {

    @Autowired
   private BooksRepo booksRepo;

    @Autowired
    BookController bookController;

    @Autowired
    CategoryRepo categoryRepo;


    public Books addBook(Books book){
    return booksRepo.save(book);
    }

    public void updateBook(Books books){
        booksRepo.save(books);
    }

    public void deleteBook(Long id){
        booksRepo.deleteById(id);
    }

    public Books getBookById(Long bookId){
        Optional<Books> books = booksRepo.findById(bookId);
        return books.orElse(null);
    }

    public List<Books> findAll() {
        return new ArrayList<>(booksRepo.findAll());
    }

    public List<Books> getBookByName(String title){
        return booksRepo.getBooksByTitle(title);
    }
}
