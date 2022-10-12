package com.example.retos.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class Farm implements Serializable {
    // *DECLARACION VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "exension")
    private Integer exension;

    @Column(name = "description")
    private String description;
     // relacion column ID con MESSAGES Y RESERVATION//
    // messages
    @OneToMany(mappedBy="farm", cascade=CascadeType.ALL)
    private Set<Messages>message=new HashSet<>();
    // reservation
    @OneToMany(mappedBy="farm", cascade=CascadeType.ALL)
    private Set<Reservation>reservation=new HashSet<>();
    // VARIABLES CON RELACION CATEGOTY
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

  

    // *CONSTRUCTOR
   
    public Farm() {
       
    }

    // *GETTER Y SETTERS
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExension() {
        return exension;
    }

    public void setExension(Integer exension) {
        this.exension = exension;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
