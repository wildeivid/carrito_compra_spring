package com.carritocompra.app.models.service;

import java.util.List;

import com.carritocompra.app.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios();
	
	public void guardarUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long usuario);
	
	public Usuario buscarUsuarioPorId(Long idUsuario);
	
	public Usuario buscarUsuario(Usuario usuario);

}
