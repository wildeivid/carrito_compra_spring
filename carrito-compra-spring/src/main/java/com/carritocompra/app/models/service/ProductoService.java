package com.carritocompra.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.IProductoDAO;
import com.carritocompra.app.models.entity.Producto;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private IProductoDAO productoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> listaProductos() {
		return (List<Producto>) this.productoDao.findAll();
	}

	@Override
	@Transactional
	public void guardarProducto(Producto producto) {
		this.productoDao.save(producto);
	}

	@Override
	@Transactional
	public void editarProducto(Producto producto) {
		this.productoDao.save(producto);
	}

	@Override
	@Transactional
	public void eliminarProducto(Long id) {
		this.productoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto buscarProductoPorId(Long id) {
		return this.productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto buscarProducto(Producto producto) {
		return this.productoDao.findById(producto.getId()).orElse(null);
	}

}
