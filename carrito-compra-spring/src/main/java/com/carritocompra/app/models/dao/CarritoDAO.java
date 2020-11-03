package com.carritocompra.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carritocompra.app.Types.StatusType;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;

@Repository
public class CarritoDAO implements ICarritoDAO {
	
	private final StringBuilder SQL_CONSULTA_CARRITO_DISPONIBLE = new StringBuilder("SELECT * FROM carts WHERE usuario_id= :usuario_id and status= :status");
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Carrito buscarAndAsignarCarrito(Usuario usuario) {
		Carrito carrito = null;
		
		Query query = this.entityManager.createNativeQuery(SQL_CONSULTA_CARRITO_DISPONIBLE.toString(), Carrito.class);
		query.setParameter("usuario_id", usuario.getId());
		query.setParameter("status", StatusType.PENDING.getStatus());
		
		try {
			carrito = (Carrito) query.getSingleResult();
		}catch (NoResultException e) {
			carrito = new Carrito();
			carrito.setUsuario(usuario);
			carrito.setStatus(StatusType.PENDING.getStatus());
			this.entityManager.persist(carrito);
			carrito = (Carrito) query.getSingleResult();
		}
		
		return carrito;
	}

	@Override
	public void checkoutCarrito(Carrito carrito) {
		carrito.setStatus(StatusType.COMPLETED.getStatus());
		this.entityManager.merge(carrito);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrito> misCompras(Long id) {
		//List<Carrito> compras = null;
		
		return this.entityManager.createQuery("from Carrito as c where c.usuario.id=".concat(id.toString())).getResultList();
		
		//return compras;
	}

}
