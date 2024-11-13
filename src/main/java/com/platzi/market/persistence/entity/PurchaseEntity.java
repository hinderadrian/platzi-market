package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long purchaseId;

    @Column(name = "id_cliente")
    private String customerId;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "estado")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<ProductPurchaseEntity> productPurchasesEntity;
}
