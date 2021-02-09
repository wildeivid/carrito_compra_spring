package com.carritocompra.app.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.sun.istack.Nullable;

@Entity
@Table(name = "carritos")
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
	
	@Nullable
	private BigDecimal total;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "carrito_id")
	private List<CarritoProducto> listaProductoCarrito;
	
	
	

	public Carrito() {
		
	}

	public Carrito(@NotNull String status, Usuario usuario, List<CarritoProducto> listaProductoCarrito, BigDecimal total) {
		this.status = status;
		this.usuario = usuario;
		this.listaProductoCarrito = listaProductoCarrito;
		this.total = total;
	}

	public Carrito(Long id, @NotNull String status, Usuario usuario, List<CarritoProducto> listaProductoCarrito, BigDecimal total) {
		this.id = id;
		this.status = status;
		this.usuario = usuario;
		this.listaProductoCarrito = listaProductoCarrito;
		this.total = total;
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

	public List<CarritoProducto> getListaProductoCarrito() {
		return listaProductoCarrito;
	}

	public void setListaProductoCarrito(List<CarritoProducto> listaProductoCarrito) {
		this.listaProductoCarrito = listaProductoCarrito;
	}

	public BigDecimal getTotal() {
		return total != null ? total : this.getTotalCalculado();
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public BigDecimal getTotalCalculado() {
		BigDecimal total = new BigDecimal(0);
		
		for (CarritoProducto productoCarrito : listaProductoCarrito) {
			total = total.add(productoCarrito.getProducto().getPrecio().multiply(new BigDecimal(productoCarrito.getCantidad())));
		}
		
		return total;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
