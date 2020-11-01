package com.carritocompra.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.IUsuarioDAO;
import com.carritocompra.app.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios() {
		return this.usuarioDao.listarUsuarios();
	}

	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario) {
		this.usuarioDao.guardarUsuario(usuario);
	}

	@Override
	@Transactional
	public void editarUsuario(Usuario usuario) {
		this.usuarioDao.editarUsuario(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long id) {
		this.usuarioDao.eliminarUsuario(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarUsuarioPorId(Long idUsuario) {
		return this.usuarioDao.buscarUsuarioPorId(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarUsuario(Usuario usuario) {
		return this.usuarioDao.buscarUsuario(usuario);
	}

}
