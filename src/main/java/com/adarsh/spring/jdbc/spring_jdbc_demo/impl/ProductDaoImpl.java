package com.adarsh.spring.jdbc.spring_jdbc_demo.impl;

import com.adarsh.spring.jdbc.spring_jdbc_demo.dao.ProductDao;
import com.adarsh.spring.jdbc.spring_jdbc_demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        String createQuery="create table if not exists Product(id int primary key,title varchar(200) not null,description varchar(500),price int)";
        jdbcTemplate.update(createQuery);
    }

    @Override
    public Product createProd(Product product) {
        String query="insert into product (id,title,description,price) values(?,?,?,?)";
      int update=  jdbcTemplate.update(query,product.getId(),product.getTitle(),product.getDescription(),product.getPrice());
        System.out.println(update+" rows affected");
      return product;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        String query="update product set title='s 114' where id= "+productId;
        jdbcTemplate.update(query);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {

        String query="select* from product";
        List<Product> products=jdbcTemplate.query(query, new RowMapper<Product>() {
             @Override
             public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Product product=new Product();
                 product.setId(rs.getInt("id"));
                 product.setTitle(rs.getString("title"));
                 product.setDescription(rs.getString("description"));
                 product.setPrice(rs.getInt("price"));
                 return product;
             }
         });
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        String query="select * from product where id= "+productId;
       return jdbcTemplate.queryForObject(query, new RowMapper<Product>() {
           @Override
           public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
               Product p=new Product();
               p.setId(rs.getInt("id"));
               p.setTitle(rs.getString("title"));
               p.setDescription(rs.getString("description"));
               p.setPrice(rs.getInt("price"));
               return p;
           }
       });
    }

    @Override
    public void deleteProd(int id) {
        String query="delete from product where id="+id;
        System.out.println("Product with id "+id +" is deleted");
        jdbcTemplate.execute(query);
    }
}
