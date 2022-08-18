package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.PostagemModel;

@Repository // Essa classe se trata de um repositório que vai se comunicar com o db.
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> { // Tipo de entidade e tipo de Id dela.
																					// O JpaRepository é a superclasse.
	public List<PostagemModel> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo); // Buscar todos pelo
																									// título.

}
