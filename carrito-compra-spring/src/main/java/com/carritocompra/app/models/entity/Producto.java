package com.carritocompra.app.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=3, max=50)
	@Column(nullable = false)
	private String nombre;
	
	@NotNull
	@Column(nullable = false)
	private BigDecimal sku;
	
	@NotBlank
	@Size(min=3, max=150)
	@Column(nullable = false)
	private String descripcion;
	
	


	public Producto() {
		
	}

	public Producto(@NotBlank @Size(min = 3, max = 50) String nombre, 
			@NotNull BigDecimal sku,
			@NotBlank @Size(min = 3, max = 150) String descripcion) {
		this.nombre = nombre;
		this.sku = sku;
		this.descripcion = descripcion;
	}

	public Producto(Long id, 
			@NotBlank @Size(min = 3, max = 50) String nombre, 
			@NotNull BigDecimal sku,
			@NotBlank @Size(min = 3, max = 150) String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.sku = sku;
		this.descripcion = descripcion;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSku() {
		return sku;
	}

	public void setSku(BigDecimal sku) {
		this.sku = sku;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
