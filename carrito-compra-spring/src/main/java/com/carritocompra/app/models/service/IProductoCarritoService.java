package com.carritocompra.app.models.service;

import java.util.List;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.ProductoCarrito;
import com.carritocompra.app.models.entity.ProductoFinal;

public interface IProductoCarritoService {
	
	public ProductoCarrito isExisteProductoIntoCarrito(Carrito carrito, Producto producto);
	
	public void incrementarProductoCarrito(ProductoCarrito productoCarrito);
	
	public int cantidadProductoIntoCarrito(Carrito carrito);
	
	public List<ProductoFinal> listarProductosCarrito(Carrito carrito);
	
	public void eliminarOfCarrito(Long id);
	
	public void modificarCantidadOfProductoOfCarrito(Long id, Integer quantity);
	
}
