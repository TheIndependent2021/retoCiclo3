package com.example.retos.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="category")
public class Category implements Serializable {
// *DECLARACION DE VARIABLES
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name="name")
private String name;

@Column(name="description")
private String description;
//*RELACION UNO A UNO CON farm 
// @OneToOne(mappedBy="category")
// private Farm farm;
// *CONSTRUCTOR
public Category() {
   
}
//  *getter y setter



public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}
// get y set de Farm
// public Farm getFarm() {
//     return farm;
// }

// public void setFarm(Farm farm) {
//     this.farm = farm;
// }
}
