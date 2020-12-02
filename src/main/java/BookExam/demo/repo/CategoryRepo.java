package BookExam.demo.repo;

import BookExam.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM BOOKS WHERE CATEGORY = ?1", nativeQuery = true)
    public String getAllBooksByCategory(Long category);
}
