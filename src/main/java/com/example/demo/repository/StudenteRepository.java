package com.example.demo.repository;


import com.example.demo.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {

    @Query(value = "SELECT * FROM studenti ORDER BY nome ASC", nativeQuery = true)
    List<Studente> ordina_by_nome_asc();

    @Query(value = "SELECT * FROM studenti ORDER BY nome DESC", nativeQuery = true)
    List<Studente> ordina_by_nome_desc();
}