package model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int order_item_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Fremmednøgle fra order
    private Order order;

    private String order_item_name;
    private int order_item_price;

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    public int getOrder_item_price() {
        return order_item_price;
    }

    public void setOrder_item_price(int order_item_price) {
        this.order_item_price = order_item_price;
    }
}
