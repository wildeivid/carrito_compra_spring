package com.carritocompra.app.models.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carritocompra.app.models.dao.ICarritoDAO;
import com.carritocompra.app.models.dao.IProductoCarritoDAO;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.CarritoProducto;
import com.carritocompra.app.models.entity.ProductoFinal;

@Service
public class ProductoCarritoService implements ICarritoProductoService {
	
	@Autowired
	private IProductoCarritoDAO iProductoCarritoDAO;
	
	@Autowired
	private ICarritoDAO iCarritoDAO;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoCarritoService.class);
	
	
	@Transactional(readOnly = true)
	@Override
	public CarritoProducto isExisteProductoEnElCarrito(Carrito carrito, Producto producto) {
		CarritoProducto productoCarrito = this.iProductoCarritoDAO.findByCarritoAndProducto(carrito, producto);
		
		if(productoCarrito == null) {
			productoCarrito = new CarritoProducto();
			LOGGER.info("En el carrito - No existe el producto con codigo ".concat(producto.getId().toString()).concat(" - ").concat(producto.getNombre()));
		}
		
		return productoCarrito;

	}
	
	@Transactional
	@Override
	public void incrementarProductoCarrito(CarritoProducto productoCarrito) {
		productoCarrito.setCantidad(productoCarrito.getCantidad() + 1);
		this.iProductoCarritoDAO.save(productoCarrito);
	}

	@Override
	public int cantidadProductoAlCarrito(Carrito carrito) {
		return this.iProductoCarritoDAO.countByCarrito(carrito);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductoFinal> listarProductosCarrito(Carrito carrito) {
		List<CarritoProducto>productosCarrito = this.iProductoCarritoDAO.findByCarrito(carrito);
		List<ProductoFinal> listaFinal = null;
		
		if(productosCarrito != null) {
			listaFinal = new ArrayList<>();
			
			for (CarritoProducto productoCarrito : productosCarrito) {
				listaFinal.add(new ProductoFinal(productoCarrito, productoCarrito.getProducto()));
			}
		}else {
			LOGGER.info("No hay productos en el carrito");
		}
		
		return listaFinal;
	}
	
	@Transactional
	@Override
	public void eliminarProductoDelCarrito(Long id) {
		this.iProductoCarritoDAO.deleteById(id);
		
	}
	
	@Transactional
	@Override
	public void modificarCantidadDeProductoDelCarrito(Long id, Integer cantidad) {
		CarritoProducto productoCarrito = this.iProductoCarritoDAO.findById(id).orElse(null);
		productoCarrito.setCantidad(cantidad);
		this.iProductoCarritoDAO.save(productoCarrito);
	}
	
	@Transactional(readOnly = true)
	@Override 
	public List<CarritoProducto>listarDetalleCarrito(Long id) {
		Carrito carrito = this.iCarritoDAO.findById(id).orElse(null);
		if(carrito != null) {
			return this.iProductoCarritoDAO.findByCarrito(carrito);
		}
		return null;
	}
	

}
