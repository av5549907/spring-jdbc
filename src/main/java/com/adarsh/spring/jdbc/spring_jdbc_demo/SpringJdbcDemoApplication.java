package com.adarsh.spring.jdbc.spring_jdbc_demo;

import com.adarsh.spring.jdbc.spring_jdbc_demo.dao.ProductDao;
import com.adarsh.spring.jdbc.spring_jdbc_demo.impl.ProductDaoImpl;
import com.adarsh.spring.jdbc.spring_jdbc_demo.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(SpringJdbcDemoApplication.class, args);

		//Product product=context.getBean(Product.class);
		Product product=new Product();
		product.setId(102);
		product.setTitle("S 144");
		product.setDescription("This product is for girls only");
        product.setPrice(10000);
		System.out.println(product);
//		ProductDaoImpl productDaoimpl=context.getBean(ProductDaoImpl.class);
//	    productDaoimpl.createProd(product);
		ProductDao productDao=context.getBean(ProductDao.class);
//		productDao.createProd(product);
//		productDao.updateProduct(product,102);
		List<Product> productList=productDao.getAllProduct();
		System.out.println(productList.size());
		productList.stream().forEach(x-> System.out.println(x));
		Product p=productDao.getProductById(101);
		System.out.println(productDao.getProductById(101));
        productDao.deleteProd(101);
		productDao.getAllProduct().forEach(x-> System.out.println(x));
		System.out.println(productList.size());
		productDao.createProd(p);
		System.out.println(productList.size());

	}

}
