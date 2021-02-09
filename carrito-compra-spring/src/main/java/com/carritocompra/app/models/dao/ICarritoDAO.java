package com.carritocompra.app.models.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;

public interface ICarritoDAO extends CrudRepository<Carrito, Long>{
	
	
	public List<Carrito> findByUsuario(Usuario usuario); 
	
	public Carrito findByUsuarioAndStatus(Usuario usuario, String status);
	
}
