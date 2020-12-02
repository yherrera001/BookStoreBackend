package BookExam.demo.service;

import BookExam.demo.pojo.Books;
import BookExam.demo.pojo.Category;
import BookExam.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }

    public void updateCategory(Category categoryId, Long id){
        categoryRepo.save(categoryId);
    }

    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }

    public Category getCategoryById(Long bookId){
        Optional<Category> books = categoryRepo.findById(bookId);
        return books.orElse(null);
    }

    public List<Category> findAll() {
        return new ArrayList<>(categoryRepo.findAll());
    }
}
