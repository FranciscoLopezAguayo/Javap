package com.javap.fjla.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="INVOICES")
public class Invoice {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceLine> lines;

    /** GET and SET */
}
