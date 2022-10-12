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

import com.example.retos.entities.Cliente;
import com.example.retos.services.ClienteServices;

@Service
@RestController
@RequestMapping("api/Client")
public class ClienteController {
    @Autowired
    ClienteServices clienteService;

    public ClienteController(ClienteServices clienteService) {
        this.clienteService = clienteService;
    }

    // GET
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getClientes() {
        return new ResponseEntity<List<Cliente>>(this.clienteService.getListCliente(), HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") int id) {
        return new ResponseEntity<Cliente>(this.clienteService.getCliente(id), HttpStatus.OK);
    }

    // POST CREAR
    @PostMapping("/save")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<Cliente>(this.clienteService.crearCliente(cliente), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("id") int id) {
        this.clienteService.eliminarCliente(id);
        return new ResponseEntity<String>("Cliente eliminado", HttpStatus.NO_CONTENT);
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        this.clienteService.actualizarCliente(id, cliente);
        return new ResponseEntity<String>("Cliente actualizado", HttpStatus.CREATED);
    }

}
