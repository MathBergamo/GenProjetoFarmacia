package com.generation.farmacia.Repository;

import com.generation.farmacia.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByAtivoTrue();

}
