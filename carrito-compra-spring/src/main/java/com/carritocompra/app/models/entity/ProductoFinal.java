package com.carritocompra.app.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoFinal implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductoCarrito productoCarrito;
	private Producto producto;
	private BigDecimal subTotal;
	private BigDecimal total;

	public ProductoFinal() {

	}

	public ProductoFinal(ProductoCarrito productoCarrito, Producto producto, BigDecimal subTotal) {
		this.productoCarrito = productoCarrito;
		this.producto = producto;
		this.subTotal = subTotal;
	}

	public ProductoCarrito getProductoCarrito() {
		return productoCarrito;
	}

	public void setProductoCarrito(ProductoCarrito productoCarrito) {
		this.productoCarrito = productoCarrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

}
