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

import com.example.retos.entities.Farm;
import com.example.retos.services.FarmService;

@Service
@RestController
@RequestMapping("api/Farm")
public class FarmController {
    @Autowired
    FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // GET
    @GetMapping("/all")
    public ResponseEntity<List<Farm>> getFarms() {
        return new ResponseEntity<List<Farm>>(this.farmService.getListFarm(), HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable("id") int id) {
        return new ResponseEntity<Farm>(this.farmService.getFarm(id), HttpStatus.OK);
    }

    // POST CREAR
    @PostMapping("/save")
    public ResponseEntity<Farm> crearFarm(@RequestBody Farm Farm) {
        return new ResponseEntity<Farm>(this.farmService.crearFarm(Farm), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFarm(@PathVariable("id") int id) {
        this.farmService.eliminarFarm(id);
        return new ResponseEntity<String>("Farm eliminado", HttpStatus.NO_CONTENT);
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarFarm(@PathVariable("id") int id, @RequestBody Farm farm) {
        this.farmService.actualizarFarm(id, farm);
        return new ResponseEntity<String>("Farm actualizado", HttpStatus.CREATED);
    }
}
