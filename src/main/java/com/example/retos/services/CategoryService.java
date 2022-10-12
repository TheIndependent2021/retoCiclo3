package com.example.retos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.retos.entities.Category;
import com.example.retos.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    // CONSTRUCTOR
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // CRUD
    // GET-OBTENER TODOS
    public List<Category> getListCategory() {
        return this.categoryRepository.findAll();
    }

    // GET ID
    public Category getCategory(int id) {
        if (!this.categoryRepository.findById(id).isEmpty()) {
            return this.categoryRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // DELETE-BORRAR
    public boolean eliminarCategory(int id) {
        if (!this.categoryRepository.findById(id).isEmpty()) {
            this.categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // POST-SAVE
    public Category crearCategory(Category category) {
        return this.categoryRepository.save(category);
    }
}
