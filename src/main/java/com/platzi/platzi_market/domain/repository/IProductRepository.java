package com.platzi.platzi_market.domain.repository;

import com.platzi.platzi_market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(long categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProduct(long productId);
    Product save(Product product);
    void delete(long productId);
}
