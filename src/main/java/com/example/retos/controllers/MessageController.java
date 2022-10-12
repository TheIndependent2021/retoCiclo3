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

import com.example.retos.entities.Messages;
import com.example.retos.services.MessagesService;

@Service
@RestController
@RequestMapping("api/Message")
public class MessageController {
    @Autowired
    MessagesService messageService;

    public MessageController(MessagesService messageService) {
        this.messageService = messageService;
    }

    // GET
    @GetMapping("/all")
    public ResponseEntity<List<Messages>> getMessages() {
        return new ResponseEntity<List<Messages>>(this.messageService.getListMessages(), HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Messages> getMessage(@PathVariable("id") int id) {
        return new ResponseEntity<Messages>(this.messageService.getMessages(id), HttpStatus.OK);
    }

    // POST CREAR
    @PostMapping("/save")
    public ResponseEntity<Messages> crearMessage(@RequestBody Messages Message) {
        return new ResponseEntity<Messages>(this.messageService.crearMessages(Message), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMessages(@PathVariable("id") int id) {
        this.messageService.eliminarMessages(id);
        return new ResponseEntity<String>("Message eliminado", HttpStatus.NO_CONTENT);
    } 
       // put
       @PutMapping("/{id}")
       public ResponseEntity<String> actualizarMessages(@PathVariable("id") int id, @RequestBody Messages messages) {
           this.messageService.actualizarMessages(id, messages);
           return new ResponseEntity<String>("Messages actualizado", HttpStatus.CREATED);
       }
}
