package com.javap.fjla.persistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_lines")
public class InvoiceLine {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT", nullable = false)
    private String product;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "TOTAL", nullable = false)
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "FK_INVOICE", nullable = false, updatable = false)
    private Invoice invoice;

    /** GET and SET */

}
