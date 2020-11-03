package com.carritocompra.app.models.dao;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.ProductoCarrito;
import com.carritocompra.app.models.entity.ProductoFinal;

import java.util.List;

public interface IProductoCarritoDAO {
	
	public ProductoCarrito isExisteProductoIntoCarrito(Carrito carrito, Producto producto);
	
	public void incrementarProductoCarrito(ProductoCarrito productoCarrito);
	
	public int cantidadProductoIntoCarrito(Carrito carrito);
	
	public List<ProductoFinal> listarProductosCarrito(Carrito carrito);
	
	public void eliminarOfCarrito(Long id);
	
	public void modificarCantidadOfProductoOfCarrito(Long id, Integer quantity);
	
}
