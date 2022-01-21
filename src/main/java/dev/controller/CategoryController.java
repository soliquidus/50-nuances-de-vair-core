package dev.controller;

import dev.entity.Category;
import dev.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok().body(this.categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.categoryService.getCategory(id));
    }

    @PostMapping()
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok().body(this.categoryService.addCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok().body(id);
    }

}
