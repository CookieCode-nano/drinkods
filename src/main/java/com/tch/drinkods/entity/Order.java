package com.tch.drinkods.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false)
    private Drink drink;

    @ManyToOne
    @JoinColumn(name = "orderer_id", nullable = false)
    private Orderer orderer;

    private String customizations;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Constructors, Getters, and Setters
    public Order() {}

    public Order(Drink drink, Orderer orderer, String customizations, LocalDateTime timestamp) {
        this.drink = drink;
        this.orderer = orderer;
        this.customizations = customizations;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public void setOrderer(Orderer orderer) {
        this.orderer = orderer;
    }

    public String getCustomizations() {
        return customizations;
    }

    public void setCustomizations(String customizations) {
        this.customizations = customizations;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}