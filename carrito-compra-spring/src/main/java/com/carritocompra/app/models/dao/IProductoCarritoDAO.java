package com.carritocompra.app.models.dao;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.CarritoProducto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IProductoCarritoDAO extends CrudRepository<CarritoProducto, Long>{
	
	public List<CarritoProducto> findByCarrito(Carrito carrito);
	
	public int countByCarrito(Carrito carrito);
	
	public CarritoProducto findByCarritoAndProducto(Carrito carrito, Producto producto);
	
}
