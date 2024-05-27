package com.dsbd.project.controller;

import com.dsbd.project.entity.Product;
import com.dsbd.project.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping(path="/add")
    public @ResponseBody Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody Optional<Product> getProduct(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "Product with id " + id + " was deleted!";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody String updateProduct(@PathVariable int id,
                                              @RequestParam(required = false) String nome,
                                              @RequestParam(required = false) String marca,
                                              @RequestParam(required = false) Float prezzo,
                                              @RequestParam(required = false) Integer quantita){

            Product product = productRepository.findById(id).get();
            if (nome != null) product.setName(nome);
            if (marca != null) product.setMarca(marca);
            if (prezzo != null) product.setPrezzo(prezzo);
            if (quantita != null) product.setQuantita(quantita);
            productRepository.save(product);
            return "Product with id " + id + " has been modified!";
            //TODO Risolvere problema di key nulle, reinserire try catch
    }
}

