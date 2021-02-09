package com.carritocompra.app.models.dao;


import org.springframework.data.repository.CrudRepository;
import com.carritocompra.app.models.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long> {
	
	
	
}
