package com.platzi.platzi_market.persistence;

import com.platzi.platzi_market.persistence.crud.ProductCrudRepository;
import com.platzi.platzi_market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
    }

    public Optional<List<Product>> indProductsWithLowStock(int quantity) {
        return productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
    }

    public Optional<Product> getProductById(Long id) {
        return productCrudRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct(long productId) {
        productCrudRepository.deleteById(productId);
    }
}
