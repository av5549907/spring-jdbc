package com.adarsh.spring.jdbc.spring_jdbc_demo.dao;

import com.adarsh.spring.jdbc.spring_jdbc_demo.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    Product createProd(Product product);

    Product updateProduct(Product product,int productId);

    List<Product> getAllProduct();

    Product getProductById(int productId);

    void deleteProd(int id);



}
