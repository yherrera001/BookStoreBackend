package BookExam.demo.repo;

import BookExam.demo.pojo.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public interface BooksRepo extends JpaRepository<Books, Long> {

    @Query(value = "SELECT * FROM BOOKS WHERE TITLE =?1", nativeQuery = true)
    public List<Books> getBooksByTitle(String title);
}
