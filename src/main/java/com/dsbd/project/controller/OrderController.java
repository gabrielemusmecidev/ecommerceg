package com.dsbd.project.controller;

import com.dsbd.project.entity.*;
import com.dsbd.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
    FinalOrderRepository finalOrderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addOrder(@RequestBody OrderRequest orderRequest) {
        Optional<User> user = userRepository.findById(orderRequest.getUserId());
        if (user.isEmpty()) return "User not found";
        //.isEmpty è implementato nella libreria della classe Optional
        List<OrderProduct> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : orderRequest.getProducts().entrySet()){
            try {
                //Serve a cercare nel repository il prodotto con dato id e verificare
                //che ci sia una quantità sufficiente alla richiesta

                //Verifica che il productRepository contenga quel prodotto (in base all'id) in qunatità >=richiesta
                Product product = productRepository.findByIdAndQuantitaGreaterThan(entry.getKey(), entry.getValue());

                //Aggiungo alla lista un nuovo ordine determinato dal prodotto e qantità
                list.add(new OrderProduct().setProduct(product).setQuantity(entry.getValue()));

                //Aggiorno la quantità dei prodotti rimanenti
                product.setQuantita(product.getQuantita() - entry.getValue());
            }catch(Exception e){
                return "Not enough products in DB";
            }
        }
        //L'ordine finale sarà un nuovo ordine finale con utente preso da user.get() e come prodotti la lista appena fatta
        FinalOrder finalOrder = new FinalOrder().setUser(user.get()).setProducts(list);
        finalOrderRepository.save(finalOrder);
        return "Order added \n"+finalOrder.toString();
    }

    @GetMapping(path = "/id/{id}")
    public @ResponseBody Optional<FinalOrder> getOrderById(@PathVariable Integer id) {
        return finalOrderRepository.findById(id);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FinalOrder> getAllOrders() {
        return finalOrderRepository.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteOrderById(@PathVariable Integer id) {
        Optional<FinalOrder> finalOrder = finalOrderRepository.findById(id);
        if (finalOrder.isEmpty()) return "Order not found";
        finalOrderRepository.delete(finalOrder.get());
        return "Order with id "+id+" deleted!";
    }
}

