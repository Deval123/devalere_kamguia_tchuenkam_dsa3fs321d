package com.devalere.security.repositories;

import com.devalere.security.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories()
public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}
