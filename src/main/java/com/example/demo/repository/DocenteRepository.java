package com.example.demo.repository;


import com.example.demo.entity.Docente;
import com.example.demo.entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    @Query(value = "SELECT * FROM docenti ORDER BY nome ASC", nativeQuery = true)
    List<Docente> ordina_by_nome_asc();

    @Query(value = "SELECT * FROM docenti ORDER BY nome DESC", nativeQuery = true)
    List<Docente> ordina_by_nome_desc();

}
