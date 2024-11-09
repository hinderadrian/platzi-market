package com.platzi.platzi_market.persistence.crud;

import com.platzi.platzi_market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Long> {

    public List<ProductEntity> findByCategoryIdOrderByNameAsc(Long categoryId);

    Optional<List<ProductEntity>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
