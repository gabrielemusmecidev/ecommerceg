package com.dsbd.project.entity;

import org.springframework.data.repository.CrudRepository;

public interface FinalOrderRepository extends CrudRepository<FinalOrder, Integer> {
    //contiene gli oridni in fase di "evasione" dopo che i prodotti sono stati prelevati dall'user

}
