package com.example.retos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos.entities.Reservation;
import com.example.retos.repositories.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRep;

    // CONSTRUCTOR
    public ReservationService(ReservationRepository reservationRep) {
        this.reservationRep = reservationRep;
    }

    // CRUD
    //GET ALL
    public List<Reservation> getListReservation() {
        return this.reservationRep.findAll();
    }

    //GET BY ID
    public Reservation getReservation(int id){
        return this.reservationRep.findById(id).get();
    }

    //POST CREAR
    public Reservation crearReservation(Reservation reservation){
        return this.reservationRep.save(reservation);
    }

    //DELETE BY ID
    public boolean eliminarReservation(int id){
        if (!this.reservationRep.findById(id).isEmpty()) {
            this.reservationRep.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
