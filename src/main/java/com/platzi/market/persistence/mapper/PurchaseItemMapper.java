package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ProductPurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mapping(target = "productId", source = "id.productId")
    @Mapping(target = "active", source = "state")
    PurchaseItem toPurchaseItem(ProductPurchaseEntity productPurchaseEntity);

    @InheritInverseConfiguration
    @Mapping(target = "purchaseEntity", ignore = true)
    @Mapping(target = "productEntity", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    ProductPurchaseEntity toProductPurchaseEntity(PurchaseItem purchaseItem);
}
