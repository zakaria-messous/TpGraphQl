package org.example.tpgraphql.controller;

import org.example.tpgraphql.entity.Compte;
import org.example.tpgraphql.entity.Transaction;
import org.example.tpgraphql.repository.CompteRepository;
import org.example.tpgraphql.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CompteControllerGraphQL {
    private final CompteRepository compteRepository;
    private final TransactionRepository transactionRepository;

    @QueryMapping
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
    }

    @MutationMapping
    public Compte saveCompte(@Argument Compte compte) {
        return compteRepository.save(compte);
    }

    @MutationMapping
    public Transaction addTransaction(@Argument Transaction transaction) {
        Compte compte = compteRepository.findById(transaction.getCompte().getId())
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        transaction.setCompte(compte);
        return transactionRepository.save(transaction);
    }

    @QueryMapping
    public List<Transaction> compteTransactions(@Argument Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        return transactionRepository.findAll();
    }
}

