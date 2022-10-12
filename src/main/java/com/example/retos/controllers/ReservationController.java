package com.example.retos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos.entities.Reservation;
import com.example.retos.services.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationSer;

    public ReservationController(ReservationService reservationSer) {
        this.reservationSer = reservationSer;
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservations() {
        return new ResponseEntity<List<Reservation>>(this.reservationSer.getListReservation(), HttpStatus.OK);
    }

    // POST SAVE
    @PostMapping("/save")
    public ResponseEntity<Reservation> crearReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<Reservation>(this.reservationSer.crearReservation(reservation), HttpStatus.OK);
    }
}
