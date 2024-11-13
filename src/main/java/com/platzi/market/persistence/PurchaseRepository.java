package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.IPurchaseRepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.entity.PurchaseEntity;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final PurchaseCrudRepository purchaseCrudRepository;
    private final PurchaseMapper purchaseMapper;

    @Autowired
    public PurchaseRepository(PurchaseCrudRepository purchaseCrudRepository, PurchaseMapper purchaseMapper) {
        this.purchaseCrudRepository = purchaseCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseMapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> findByCustomer(String customerId) {
        return purchaseCrudRepository.findByCustomerId(customerId)
                .map(purchaseMapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntityMapped = purchaseMapper.toPurchaseEntity(purchase);

        purchaseEntityMapped.getProductPurchasesEntity()
                .forEach(product -> product.setPurchaseEntity(purchaseEntityMapped));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntityMapped));
    }
}
