package org.example.tpgraphql.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    private Compte compte;
}

enum TransactionType {
    DEPOT, RETRAIT
}
