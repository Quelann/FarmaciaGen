package com.farmarcia.FarmaciaGen.Repository;

import java.util.List;

/* 
 * @author Wesley Barreto Coelho
 * @since 25/01/2022
 * @version 0.01
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.farmarcia.FarmaciaGen.Model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria>findAllByCategoriaContainingIgnoreCase(String categoria);
	 
}
