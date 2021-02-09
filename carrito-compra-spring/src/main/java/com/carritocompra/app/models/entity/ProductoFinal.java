package com.carritocompra.app.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoFinal implements Serializable {

	private static final long serialVersionUID = 1L;

	private CarritoProducto productoCarrito;
	private Producto producto;
	private BigDecimal subTotal;

	public ProductoFinal() {

	}
	
	public ProductoFinal(CarritoProducto productoCarrito, Producto producto) {
		this.productoCarrito = productoCarrito;
		this.producto = producto;
	}

	public ProductoFinal(CarritoProducto productoCarrito, Producto producto, BigDecimal subTotal) {
		this.productoCarrito = productoCarrito;
		this.producto = producto;
		this.subTotal = subTotal;
	}

	public CarritoProducto getProductoCarrito() {
		return productoCarrito;
	}

	public void setProductoCarrito(CarritoProducto productoCarrito) {
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
		return subTotal != null ? subTotal : producto.getPrecio().multiply(new BigDecimal(productoCarrito.getCantidad()));
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

}
