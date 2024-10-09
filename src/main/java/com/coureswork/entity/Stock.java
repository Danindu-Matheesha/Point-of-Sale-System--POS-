package com.coureswork.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock")
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

    private double quantity;

    @ManyToMany
    @JoinTable(
        name = "stock_item",
        joinColumns = @JoinColumn(name = "stockId"),
        inverseJoinColumns = @JoinColumn(name = "itemId")
    )

    private List<Item> itemedStocks;
}
