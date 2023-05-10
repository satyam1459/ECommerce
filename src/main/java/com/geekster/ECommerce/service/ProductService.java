package com.geekster.ECommerce.service;

import com.geekster.ECommerce.model.Category;
import com.geekster.ECommerce.model.Product;
import com.geekster.ECommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public ResponseEntity<Product> getProductById(Long id) {
        Optional<Product> myProduct = productRepository.findById(id);
        if(myProduct.isPresent()){
            return new ResponseEntity<>(myProduct.get(), HttpStatus.FOUND);
        }else
            return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        Optional<List<Product>> products = Optional.of((List<Product>) productRepository.findAll());
        if(products.isPresent()){
            return new ResponseEntity<>(products.get(),HttpStatus.FOUND);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<List<Product>> getProductsByCategory(Category enumCategory) {
        String category = enumCategory.name();
        Optional<List<Product>> products = Optional.of(productRepository.findByCategory(category));
        if(products.isPresent()){
            return new ResponseEntity<>(products.get(),HttpStatus.FOUND);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<Void> deleteProductById(Long id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}