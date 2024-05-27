package com.dsbd.project.entity;

import javax.persistence.*;

//Se l'ordine è possibile definisce l'istanza dell'ordine
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //Permette più ordini per un solo prodotto
    @ManyToOne
    private Product product;

    private int quantity;

    @Transient
    //Omette dalle colonne della tabella cose che servono solo a livello logico

    public float getPrice() {
        return quantity * product.getPrezzo(); //Ritorna il prezzo dell'ordine, quindi qtà oggetto*prezzp
        //pgetPrice è il metodo getter definito nella classe entità Product
    }

    public int getId() {
        return id;
    }

    public OrderProduct setId(int id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderProduct setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderProduct setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "OrderProduct{"+
                "id="+id+
                "product="+product+
                "quaityt="+quantity+
                "}";
    }
}
