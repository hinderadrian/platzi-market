package com.platzi.platzi_market.persistence.crud;

import com.platzi.platzi_market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    public List<Product> findByCategoryIdOrderByNameAsc(Long categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
