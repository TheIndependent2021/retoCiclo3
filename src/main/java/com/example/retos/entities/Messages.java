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
@Table(name = "message")
public class Messages implements Serializable {
    // *DECLARACION DE VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MESSAGETEXT")
    private String messageText;
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
    public Messages() {
    }

    // * */ GETTER Y SETTERS
    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagetext() {
        return messageText;
    }

    public void setMessagetext(String messageText) {
        this.messageText = messageText;
    }

}
