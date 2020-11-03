package com.carritocompra.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.IProductoCarritoDAO;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.ProductoCarrito;
import com.carritocompra.app.models.entity.ProductoFinal;

@Service
public class ProductoCarritoService implements IProductoCarritoService {
	
	@Autowired
	private IProductoCarritoDAO iProductoCarritoDAO;
	
	@Transactional(readOnly = true)
	@Override
	public ProductoCarrito isExisteProductoIntoCarrito(Carrito carrito, Producto producto) {
		return this.iProductoCarritoDAO.isExisteProductoIntoCarrito(carrito, producto);
	}
	
	@Transactional
	@Override
	public void incrementarProductoCarrito(ProductoCarrito productoCarrito) {
		this.iProductoCarritoDAO.incrementarProductoCarrito(productoCarrito);
	}

	@Override
	public int cantidadProductoIntoCarrito(Carrito carrito) {
		return this.iProductoCarritoDAO.cantidadProductoIntoCarrito(carrito);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductoFinal> listarProductosCarrito(Carrito carrito) {
		return this.iProductoCarritoDAO.listarProductosCarrito(carrito);
	}
	
	@Transactional
	@Override
	public void eliminarOfCarrito(Long id) {
		this.iProductoCarritoDAO.eliminarOfCarrito(id);
		
	}
	
	@Transactional
	@Override
	public void modificarCantidadOfProductoOfCarrito(Long id, Integer quantity) {
		this.iProductoCarritoDAO.modificarCantidadOfProductoOfCarrito(id, quantity);		
	}
	

}
