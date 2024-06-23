package com.example.RestAbschluss.produkte;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produkt")
public class Produkt {


    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    private String name;
    private int kosten;




}
