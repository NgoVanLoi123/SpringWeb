package com.example.SpringWeb.repository;

import com.example.SpringWeb.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    public List<Product> findAll();

}
