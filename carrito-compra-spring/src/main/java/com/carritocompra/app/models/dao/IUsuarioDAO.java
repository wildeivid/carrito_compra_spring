package com.carritocompra.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.carritocompra.app.models.entity.Usuario;

public interface IUsuarioDAO  extends CrudRepository<Usuario, Long>{
	
	
	
}
