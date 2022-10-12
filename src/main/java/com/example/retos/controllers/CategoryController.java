package com.example.retos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos.entities.Category;
import com.example.retos.services.CategoryService;

@Service
@RestController
@RequestMapping("api/Category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    // CONSTRUCTOR

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // CONTROLADORES
    // GET
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategorys() {
        return new ResponseEntity<List<Category>>(this.categoryService.getListCategory(), HttpStatus.OK);
    }

    // GET BY ID
    // @GetMapping("/{id}")
    // public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
    // return new ResponseEntity<Category>(this.categoryService.getCategory(id),
    // HttpStatus.OK);
    // }
    // POST-CREAR
    @PostMapping("/save")
    public ResponseEntity<Category> crearCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(this.categoryService.crearCategory(category), HttpStatus.OK);
    }
}