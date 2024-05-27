package com.dsbd.project.entity;

import javax.persistence.Column;
import java.util.Map;

//Richiesta dell'ordine, associa prodotto con email di chi fa l'ordine
public class OrderRequest {
    @Column(nullable = false)
    //private String userEmail;
    private int userId;

    @Column(nullable = false)
    private Map<Integer, Integer> products;

    /*public String getUserEmail() {
        return userEmail;
    }

    public OrderRequest setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }*/

    public int getUserId() {
        return userId;
    }

    public OrderRequest setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public Map<Integer, Integer> getProducts() {
        return products;
    }

    public OrderRequest setProducts(Map<Integer, Integer> products) {
        this.products = products;
        return this;
    }
}
