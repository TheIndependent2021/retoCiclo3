package com.example.retos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retos.entities.Farm;
@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer>{
    
}
