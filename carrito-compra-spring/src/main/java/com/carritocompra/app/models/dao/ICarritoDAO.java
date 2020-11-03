package com.carritocompra.app.models.dao;

import java.util.List;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;

public interface ICarritoDAO {
	
	public Carrito buscarAndAsignarCarrito(Usuario usuario);
	
	public void checkoutCarrito(Carrito carrito);
	
	public List<Carrito> misCompras(Long id);
	
}
