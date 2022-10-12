package com.example.retos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    // *DECLARACION DE VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "STARTDATE")
    private String startDate;

   

    @Column(name = "DEVOLUTIONDATE")
    private String devolutionDate;
    // variables con relaciones
    // clave forane cliente_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Cliente idClient;
    // clave foranes farm_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FARM_ID")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Farm farm;

    // *CONSTRUCTOR
    public Reservation() {
    }

    // *GETTER Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Cliente getClient() {
        return idClient;
    }

    public void setClient(Cliente idClient) {
        this.idClient = idClient;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

}
