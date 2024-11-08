package com.platzi.platzi_market.persistence.mapper;

import com.platzi.platzi_market.domain.Product;
import com.platzi.platzi_market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "categoryEntity", target = "category")
    })
    Product toProduct(ProductEntity productEntity);

    List<Product> toProducts(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductEntity toProductEntity(Product product);
}
