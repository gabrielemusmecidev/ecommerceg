package com.dsbd.project.entity;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Product findByIdAndQuantitaGreaterThan(int id, int quantita);
}
