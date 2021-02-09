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
@Table(name = "carritos_productos")
public class CarritoProducto implements Serializable {
	
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
	private Integer cantidad;
	
	
	
	public CarritoProducto() {
		
	}

	public CarritoProducto(Producto producto, Carrito carrito, @NotNull Integer cantidad) {
		this.producto = producto;
		this.carrito = carrito;
		this.cantidad = cantidad;
	}

	public CarritoProducto(Long id, Producto producto, Carrito carrito, @NotNull Integer cantidad) {
		this.id = id;
		this.producto = producto;
		this.carrito = carrito;
		this.cantidad = cantidad;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
