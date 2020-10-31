package com.carritocompra.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carts")
public class Carrito implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String status;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	@OneToMany(targetEntity = ProductoCarrito.class)
	private List<ProductoCarrito> listaProductoCarrito;
	
	
	

	public Carrito() {
		
	}

	public Carrito(@NotNull String status, Usuario usuario, List<ProductoCarrito> listaProductoCarrito) {
		this.status = status;
		this.usuario = usuario;
		this.listaProductoCarrito = listaProductoCarrito;
	}

	public Carrito(Long id, @NotNull String status, Usuario usuario, List<ProductoCarrito> listaProductoCarrito) {
		this.id = id;
		this.status = status;
		this.usuario = usuario;
		this.listaProductoCarrito = listaProductoCarrito;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductoCarrito> getListaProductoCarrito() {
		return listaProductoCarrito;
	}

	public void setListaProductoCarrito(List<ProductoCarrito> listaProductoCarrito) {
		this.listaProductoCarrito = listaProductoCarrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
