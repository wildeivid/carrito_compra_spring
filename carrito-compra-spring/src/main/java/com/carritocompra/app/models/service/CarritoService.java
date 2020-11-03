package com.carritocompra.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.ICarritoDAO;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;

@Service
public class CarritoService implements ICarritoService {
	
	@Autowired
	private ICarritoDAO iCarritoDAO;
	
	@Transactional(readOnly = true)
	@Override
	public Carrito buscarAndAsignarCarrito(Usuario usuario) {
		return this.iCarritoDAO.buscarAndAsignarCarrito(usuario);
	}
	
	@Transactional
	@Override
	public void checkoutCarrito(Carrito carrito) {
		this.iCarritoDAO.checkoutCarrito(carrito);		
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Carrito> misCompras(Long id) {
		return this.iCarritoDAO.misCompras(id);
	}

}
