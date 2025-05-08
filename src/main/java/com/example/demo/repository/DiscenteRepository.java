package com.example.demo.repository;


import com.example.demo.entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long> {

    @Query(value = "SELECT * FROM discenti ORDER BY nome ASC", nativeQuery = true)
    List<Discente> ordina_by_nome_asc();

    @Query(value = "SELECT * FROM discenti ORDER BY nome DESC", nativeQuery = true)
    List<Discente> ordina_by_nome_desc();


}