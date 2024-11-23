package org.example.tpgraphql.repository;


import org.example.tpgraphql.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
