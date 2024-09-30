package com.coureswork.Coureswork.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDateTime stockDateTime;

    @PrePersist //executes before the entity is created
    protected void onCreate() {
        if(this.stockDateTime == null) {
            this.stockDateTime = LocalDateTime.now();
        }
    }

    private int quantity;
}
