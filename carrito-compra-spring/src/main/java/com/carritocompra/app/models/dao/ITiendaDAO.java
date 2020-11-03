package com.carritocompra.app.models.dao;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;

public interface ITiendaDAO {
	
	public void addProductoToCarrito(Carrito carrito, Producto producto);
	
}
