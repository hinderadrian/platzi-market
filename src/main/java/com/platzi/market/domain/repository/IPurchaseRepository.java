package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {

    List<Purchase> findAll();
    Optional<List<Purchase>> findByCustomer(String customerId);
    Purchase save(Purchase purchase);
}
