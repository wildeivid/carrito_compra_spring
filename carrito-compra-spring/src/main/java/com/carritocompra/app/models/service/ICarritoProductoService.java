package com.carritocompra.app.models.service;

import java.util.List;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.CarritoProducto;
import com.carritocompra.app.models.entity.ProductoFinal;

public interface ICarritoProductoService {
	
	public CarritoProducto isExisteProductoEnElCarrito(Carrito carrito, Producto producto);
	
	public void incrementarProductoCarrito(CarritoProducto productoCarrito);
	
	public int cantidadProductoAlCarrito(Carrito carrito);
	
	public List<ProductoFinal> listarProductosCarrito(Carrito carrito);
	
	public void eliminarProductoDelCarrito(Long id);
	
	public void modificarCantidadDeProductoDelCarrito(Long id, Integer cantidad);
	
	public List<CarritoProducto>listarDetalleCarrito(Long id);
	
}
