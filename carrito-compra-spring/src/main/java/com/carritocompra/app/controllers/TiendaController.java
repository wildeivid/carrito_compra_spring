package com.carritocompra.app.controllers;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.CarritoProducto;
import com.carritocompra.app.models.entity.ProductoFinal;
import com.carritocompra.app.models.entity.Usuario;
import com.carritocompra.app.models.service.ICarritoService;
import com.carritocompra.app.models.service.ICarritoProductoService;
import com.carritocompra.app.models.service.IProductoService;
import com.carritocompra.app.models.service.ITiendaService;
import com.carritocompra.app.models.service.IUsuarioService;

@Controller
public class TiendaController {
	
	private Usuario usuario;
	
	private Carrito carrito;
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private ITiendaService iTiendaService;
	
	@Autowired
	private ICarritoService iCarritoService;
	
	@Autowired
	private ICarritoProductoService iProductoCarritoService;
	
	
	@GetMapping("/tienda")
	public String listarProductosTienda(Model model, HttpSession session) {
		this.crearSession(session);
		
		int cantidadProductoAtCarrito = this.iProductoCarritoService.cantidadProductoAlCarrito(this.carrito);
		
		model.addAttribute("productos", this.iProductoService.listaProductos());
		model.addAttribute("cantidadProductoAtCarrito", cantidadProductoAtCarrito);
		
		return "tienda/ver";
	}
	
	@GetMapping("/tienda/add-producto/{id_producto}")
	public String addProductoToCarrito(@PathVariable(value = "id_producto") Long idProducto, Model model, HttpSession session) {
		Producto producto = new Producto();
		producto = this.iProductoService.buscarProductoPorId(idProducto);
		
		CarritoProducto productoCarrito = new CarritoProducto();
		productoCarrito = this.iProductoCarritoService.isExisteProductoEnElCarrito(this.carrito, producto);
		
		if(null == productoCarrito.getId()) {
			this.iTiendaService.agregarProductoAlCarrito(this.carrito, producto);
		}else {
			this.iProductoCarritoService.incrementarProductoCarrito(productoCarrito);
		}
		
		
		return "redirect:/tienda";
	}
	
	
	@GetMapping("/tienda/carrito")
	public String verCarrito(Model model) {
		List<ProductoFinal> productosCarrito = this.iProductoCarritoService.listarProductosCarrito(this.carrito);
		
		model.addAttribute("productosCarrito", productosCarrito);
		model.addAttribute("total", this.calcularTotal(productosCarrito));
		model.addAttribute("idCarrito", this.carrito.getId());
		
		return "tienda/carrito";
	}
	
	@GetMapping("/tienda/carrito/eliminar/{id}")
	public String eliminarProductoDelCarrito(@PathVariable(value = "id") Long id, Model model) {
		this.iProductoCarritoService.eliminarProductoDelCarrito(id);
		
		return "redirect:/tienda/carrito";
	}
	
	public BigDecimal calcularTotal(List<ProductoFinal> productosCarrito) {
		BigDecimal totalFinal = new BigDecimal(0);
		
		for (ProductoFinal productoFinal : productosCarrito) {
			totalFinal = totalFinal.add(productoFinal.getSubTotal());
		}
		return totalFinal;
	}
	
	@GetMapping("/tienda/carrito/checkout/{id}")
	public String checkout(@PathVariable(value = "id") Long id, Model model, HttpSession session) {
		if(this.carrito == null) {
			this.crearSession(session);
		}
		
		this.iCarritoService.checkoutCarrito(this.carrito);
		return "redirect:/";
	}
	
	@GetMapping("/tienda/mis-compras/{id}")
	public String misCompras(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("compras", this.iCarritoService.misCompras(this.iUsuarioService.buscarUsuarioPorId(id)));
		
		return "tienda/miscompras";
	}
	
	@PostMapping("/tienda/carrito/edit-producto")
	public String modificarCantidadOfProductoOfCarrito(@ModelAttribute(name = "cantidad") Integer cantidad, @ModelAttribute(value = "idProductoCarrito") Long id, Model model) {
		this.iProductoCarritoService.modificarCantidadDeProductoDelCarrito(id, cantidad);
		
		return "redirect:/tienda/carrito";
	}
	
	private void crearSession(HttpSession session) {
		if(null != session.getAttribute("usuario")) {
			session.removeAttribute("usuario");
		}
		
		this.usuario = this.iUsuarioService.buscarUsuarioPorId(Long.valueOf(1));
		session.setAttribute("usuario", this.usuario);
		
		this.carrito = this.iCarritoService.asignarCarrito(this.usuario);
	}
	
}
