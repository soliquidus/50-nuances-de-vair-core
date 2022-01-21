package dev.service;

import dev.entity.Category;
import dev.repository.CategoryRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return  this.categoryRepository.getById(id);
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }

}
