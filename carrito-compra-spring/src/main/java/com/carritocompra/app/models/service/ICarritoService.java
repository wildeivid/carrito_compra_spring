package com.carritocompra.app.models.service;

import java.util.List;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;

public interface ICarritoService {
	
	public Carrito buscarAndAsignarCarrito(Usuario usuario);
	
	public void checkoutCarrito(Carrito carrito);
	
	public List<Carrito> misCompras(Long id);
	
}
