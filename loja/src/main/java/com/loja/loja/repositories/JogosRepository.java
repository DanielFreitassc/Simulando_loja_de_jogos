package com.loja.loja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.loja.models.Jogos;

public interface JogosRepository extends JpaRepository<Jogos,Long>{

    public List<Jogos> findByTagsIn(List<String> tags);
    
}
