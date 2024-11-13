package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    private final ProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductRepository(ProductCrudRepository productCrudRepository, ProductMapper productMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(long categoryId) {
        List<ProductEntity> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.ofNullable(productMapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<ProductEntity>> products = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(long productId) {
        return productCrudRepository.findById(productId).map(productMapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        return productMapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(long productId) {
        productCrudRepository.deleteById(productId);
    }
}
