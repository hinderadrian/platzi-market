package com.platzi.platzi_market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProductPurchasePK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "id_compra")
    private Long purchaseId;

    @Column(name = "id_producto")
    private Long productId;
}
