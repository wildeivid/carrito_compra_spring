package com.carritocompra.app.models.service;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;

public interface ITiendaService {
	
	public void agregarProductoAlCarrito(Carrito carrito, Producto producto);
	
}
