package com.carritocompra.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_cars")
public class ProductoCarrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn
	private Producto producto;
	
	@ManyToOne(targetEntity = Carrito.class)
	@JoinColumn
	private Carrito carrito;
	
	@NotNull
	@Column(nullable = false)
	private Integer quantity;
	
	
	
	public ProductoCarrito() {
		
	}

	public ProductoCarrito(Producto producto, Carrito carrito, @NotNull Integer quantity) {
		this.producto = producto;
		this.carrito = carrito;
		this.quantity = quantity;
	}

	public ProductoCarrito(Long id, Producto producto, Carrito carrito, @NotNull Integer quantity) {
		this.id = id;
		this.producto = producto;
		this.carrito = carrito;
		this.quantity = quantity;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
