package com.farmarcia.FarmaciaGen.Model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/* 
 * @author Wesley Barreto Coelho
 * @since 25/01/2022
 * @version 0.01
 */

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 5, max = 250)
	private String categoria;
	
	@NotBlank
	@Size(min = 5, max = 250)
	private String ofertaDia;
	
	@NotBlank
	@Size(min = 5, max = 250)
	private String desconto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getOfertaDia() {
		return ofertaDia;
	}

	public void setOfertaDia(String ofertaDia) {
		this.ofertaDia = ofertaDia;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

}
