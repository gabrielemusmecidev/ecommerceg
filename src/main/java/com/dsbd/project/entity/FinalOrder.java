package com.dsbd.project.entity;

import javax.persistence.*;
import java.util.List;

//Gestisce e associa tutte le istanze di ordini all'utente
@Entity
public class FinalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    public User user; //L'user può fare più ordini

    @OneToMany(cascade = CascadeType.ALL) //Un ordine può essere formato da più prodotti
    //cascadde indica che le midifche effettuate verranno fatte a cascata anche sui successivi
    //A seconda di quello che si specifica come mappedBy, per esempio mappedBy=Product prodotto mappa
    //per prodotto, quindi se un prodotto viene aggiunto in un oridne verrà aggiunto anche negli altri
    public List<OrderProduct> products;

    @Transient
    public Double getTotalPrice(){ //Si occupa di ottenere il prezzo totale di tutti gli ordini
        Double totalPrice = 0.0;
        for (OrderProduct product : products) { //Si gira la lista di prodotti
            totalPrice += product.getPrice(); //Somma man mano il prezzo di ognuno
        }
        return totalPrice;
    }

    public int getId() {
        return id;
    }

    public FinalOrder setId(int id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public FinalOrder setUser(User user) {
        this.user = user;
        return this;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public FinalOrder setProducts(List<OrderProduct> products) {
        this.products = products;
        return this;
    }

    @Override
    public String toString() {
        return "FinalOrder{"+
                "id="+id+
                "user="+user+
                "products="+products+
                "}";
    }
}
