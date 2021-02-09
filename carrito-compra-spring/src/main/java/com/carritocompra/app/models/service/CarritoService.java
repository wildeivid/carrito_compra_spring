package com.carritocompra.app.models.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.carritocompra.app.Types.StatusType;
import com.carritocompra.app.models.dao.ICarritoDAO;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;

@Service
public class CarritoService implements ICarritoService {
	
	@Autowired
	private ICarritoDAO iCarritoDAO;
	
	
	@Transactional
	@Override
	public Carrito asignarCarrito(Usuario usuario) {
		Carrito carrito = this.iCarritoDAO.findByUsuarioAndStatus(usuario, StatusType.PENDING.getStatus());
		
		if(carrito == null) {
			carrito = new Carrito();
			carrito.setUsuario(usuario);
			carrito.setStatus(StatusType.PENDING.getStatus());
			this.iCarritoDAO.save(carrito);
		}
		
		return carrito;
	}
	
	@Transactional
	@Override
	public void checkoutCarrito(Carrito carrito) {
		BigDecimal totalCarrito = carrito.getTotal();
		carrito.setTotal(totalCarrito);
		carrito.setStatus(StatusType.COMPLETED.getStatus());
		this.iCarritoDAO.save(carrito);	
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Carrito> misCompras(Usuario usuario) {
		return this.iCarritoDAO.findByUsuario(usuario);
	}

	@Override
	public List<Carrito> listarCarritos() {
		return (List<Carrito>) this.iCarritoDAO.findAll();
	}

	@Override
	public int getCantidadVentasTotales() {
		return (int) this.iCarritoDAO.count();
	}

	@Override
	public Carrito buscarCarritoPorId(Long id) {
		return this.iCarritoDAO.findById(id).orElse(null);
	}
	
	

}
