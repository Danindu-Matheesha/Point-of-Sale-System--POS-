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
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime cartDateTime;

    @PrePersist
    protected void onCreate() {
        if(this.cartDateTime == null) {
            this.cartDateTime = LocalDateTime.now();
        }
    }

    private Double totalPrice;

    @ManyToMany
    @JoinTable(
        name = "cart_item",
        joinColumns = @JoinColumn(name = "cartId"),
        inverseJoinColumns = @JoinColumn(name = "itemId")
    )
    
    private List<Item> cartedItems;
}
