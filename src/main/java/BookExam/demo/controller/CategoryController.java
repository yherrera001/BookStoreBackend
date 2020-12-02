package BookExam.demo.controller;

import BookExam.demo.pojo.Category;
import BookExam.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public List<Category> getAllCategories(){
    return categoryService.findAll();
}

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category/{categoryId}")
    public void updateCategory(Category category, @PathVariable Long categoryId){
        categoryService.updateCategory(category, categoryId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{categoryId}")
    public void deleteCategoryId(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/category/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
}
