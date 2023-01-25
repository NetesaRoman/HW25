package com.example.hw25.repository;

import com.example.hw25.model.Product;
import org.springframework.data.repository.CrudRepository;

/*
 *
 * @author Roman Netesa
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
