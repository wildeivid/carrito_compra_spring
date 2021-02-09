package com.carritocompra.app.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Usuario;
import com.carritocompra.app.models.service.ICarritoService;
import com.carritocompra.app.models.service.IUsuarioService;


@Controller
public class AdminController {
	
	private Usuario usuario;
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@Autowired
	private ICarritoService iCarritoService;
	
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("tituloPrincipal", "");
		return "admin/index";
	}
	
	@GetMapping("/admin/ventas")
	public String ventas(Model model, HttpSession session) {
		if(null != session.getAttribute("usuario")) {
			session.removeAttribute("usuario");
		}
		
		this.usuario = this.iUsuarioService.buscarUsuarioPorId(Long.valueOf(1));
		session.setAttribute("usuario", this.usuario);
		
		model.addAttribute("carritos", this.iCarritoService.listarCarritos());
		model.addAttribute("cantidadVentasTotales", this.iCarritoService.getCantidadVentasTotales());
		return "admin/ventas";
	}
	
	@GetMapping("/admin/ventas/detalle/{id}")
	public String detalleVenta(@PathVariable(value = "id") Long id, Model model) {
		Carrito carrito = this.iCarritoService.buscarCarritoPorId(id); 
		model.addAttribute("productos", carrito.getListaProductoCarrito());
		model.addAttribute("total", carrito.getTotal());
		return "admin/detalleventa";
	}
	
}
