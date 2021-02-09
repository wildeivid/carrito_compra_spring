package com.carritocompra.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.carritocompra.app.models.entity.CarritoProducto;

public interface ITiendaDAO extends CrudRepository<CarritoProducto, Long> {
	
	
	
}
