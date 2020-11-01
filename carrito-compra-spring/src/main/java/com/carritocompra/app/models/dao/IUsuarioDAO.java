package com.carritocompra.app.models.dao;

import java.util.List;

import com.carritocompra.app.models.entity.Usuario;

public interface IUsuarioDAO {
	
	public List<Usuario> listarUsuarios();
	
	public void guardarUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long idUsuario);
	
	public Usuario buscarUsuarioPorId(Long idUsuario);
	
	public Usuario buscarUsuario(Usuario usuario);
	
}
