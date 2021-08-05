package com.yomyom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yomyom.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "select count(*) from Usuarios",
			nativeQuery = true)
	Integer totalEntidades();
	

}
