package com.example.retos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retos.entities.Messages;
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer>{
    
}
