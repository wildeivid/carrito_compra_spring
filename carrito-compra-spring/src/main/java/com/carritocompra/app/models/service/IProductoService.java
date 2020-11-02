package com.carritocompra.app.models.service;

import java.util.List;

import com.carritocompra.app.models.entity.Producto;

public interface IProductoService {
	
public List<Producto> listaProductos();
	
	public void guardarProducto(Producto producto);
	
	public void editarProducto(Producto producto);
	
	public void eliminarProducto(Long id);
	
	public Producto buscarProductoPorId(Long id);
	
	public Producto buscarProducto(Producto producto);

}
