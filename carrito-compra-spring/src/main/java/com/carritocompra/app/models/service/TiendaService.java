package com.carritocompra.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.ITiendaDAO;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.CarritoProducto;

@Service
public class TiendaService implements ITiendaService {
	
	@Autowired
	private ITiendaDAO iTiendaDAO;

	
	@Transactional
	@Override
	public void agregarProductoAlCarrito(Carrito carrito, Producto producto) {
		CarritoProducto productoCarrito = new CarritoProducto(producto, carrito, 1);
		this.iTiendaDAO.save(productoCarrito);
	}

}
