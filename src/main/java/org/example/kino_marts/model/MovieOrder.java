package org.example.kino_marts.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MovieOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_order_id; // Primærnøgle

    private double movie_order_total_price;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // Fremmednøgle fra Customer
    private Customer customer;

    // Én order kan have mange order_items (se ER diagram)
    @OneToMany(mappedBy = "movieOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public int getMovie_order_id() {
        return movie_order_id;
    }

    public void setMovie_order_id(int order_id) {
        this.movie_order_id = order_id;
    }

    public double getMovie_order_total_price() {
        return movie_order_total_price;
    }

    public void setMovie_order_total_price(double order_total_price) {
        this.movie_order_total_price = order_total_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
