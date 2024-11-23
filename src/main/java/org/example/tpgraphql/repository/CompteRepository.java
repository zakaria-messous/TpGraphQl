package org.example.tpgraphql.repository;

import org.example.tpgraphql.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {}

