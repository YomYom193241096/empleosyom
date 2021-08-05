package com.yomyom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yomyom.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
