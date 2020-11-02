package com.carritocompra.app.models.dao;

import java.util.List;

import com.carritocompra.app.models.entity.Producto;

public interface IProductoDAO {
	
	public List<Producto> listaProductos();
	
	public void guardarProducto(Producto producto);
	
	public void editarProducto(Producto producto);
	
	public void eliminarProducto(Long id);
	
	public Producto buscarProductoPorId(Long id);
	
	public Producto buscarProducto(Producto producto);
	
}
