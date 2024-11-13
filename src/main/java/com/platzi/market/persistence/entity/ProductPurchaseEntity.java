package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class ProductPurchaseEntity {

    @EmbeddedId
    private ProductPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchaseId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductEntity productEntity;
}
