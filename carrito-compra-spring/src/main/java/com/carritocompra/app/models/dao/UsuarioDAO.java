package com.carritocompra.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carritocompra.app.models.entity.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarUsuarios() {
		return this.entityManager.createQuery("from Usuario").getResultList();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() > 0) {
			this.entityManager.merge(usuario);
		} else {
			this.entityManager.persist(usuario);
		}
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() > 0) {
			this.entityManager.merge(usuario);
		} else {
			this.entityManager.persist(usuario);
		}
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		this.entityManager.remove(this.buscarUsuarioPorId(idUsuario));
	}

	@Override
	public Usuario buscarUsuarioPorId(Long idUsuario) {
		return this.entityManager.find(Usuario.class, idUsuario);
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		return this.entityManager.find(Usuario.class, usuario.getId());
	}

}
