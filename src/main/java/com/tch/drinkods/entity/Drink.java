package com.tch.drinkods.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

//飲料類別
@Entity
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 飲料名稱不可為無
    @Column(nullable = false)
    private String name;

    private String defaultCustomizations;

    public Drink() {
    }

    public Drink(String name) {
        this.name = name;
        this.defaultCustomizations = "原味";
    }

    public Drink(String name, String defaultCustomizations) {
        this.name = name;
        this.defaultCustomizations = defaultCustomizations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultCustomizations() {
        return defaultCustomizations;
    }

    public void setDefaultCustomizations(String defaultCustomizations) {
        this.defaultCustomizations = defaultCustomizations;
    }
}