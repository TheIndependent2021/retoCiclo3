package com.example.retos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.retos.entities.Messages;
import com.example.retos.repositories.MessagesRepository;

@Service
public class MessagesService {
    @Autowired
    private MessagesRepository messagesRepository;

    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }
    // CRUD

    // GET
    public List<Messages> getListMessages() {
        return this.messagesRepository.findAll();
    }

    // GET ID
    public Messages getMessages(int id) {
        if (!this.messagesRepository.findById(id).isEmpty()) {
            return this.messagesRepository.findById(id).get();
        } else {
            return null;
        }

    }

    // POST
    public Messages crearMessages(Messages messages) {
        return this.messagesRepository.save(messages);
    }

    // DELETE
    public boolean eliminarMessages(int id) {
        if (!this.messagesRepository.findById(id).isEmpty()) {
            this.messagesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    // PUT ACTUALIZAR
    public boolean actualizarMessages(int id, Messages messagesSet) {
        if (!this.messagesRepository.findById(id).isEmpty()) {
            Messages messages = messagesRepository.findById(id).get();
            if (messagesSet.getMessagetext() != null) {
                messages.setMessagetext(messagesSet.getMessagetext());
            }
            this.messagesRepository.save(messages);
            return true;

        } else {
            return false;
        }

    }
}
