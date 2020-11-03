package com.carritocompra.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.ITiendaDAO;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;

@Service
public class TiendaService implements ITiendaService {
	
	@Autowired
	private ITiendaDAO iTiendaDAO;

	
	@Transactional
	@Override
	public void addProductoToCarrito(Carrito carrito, Producto producto) {
		this.iTiendaDAO.addProductoToCarrito(carrito, producto);		
	}

}
