package com.example.retos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retos.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>  {
    
}
