package com.carritocompra.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.service.IProductoService;


@Controller
@SessionAttributes("producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@Value("${plantilla.productos.form.editar.titulo}")
	private String tituloEditar;
	
	@Value("${plantilla.productos.form.crear.titulo}")
	private String tituloCrear;
	
	
	@GetMapping("/productos")
	public String verProductos(Model model) {
		model.addAttribute("productos", this.productoService.listaProductos());
		
		return "productos/ver";
	}
	
	@GetMapping("/productos/crear")
	public String crearProductos(Model model) {
		Producto pruducto = new Producto();
		model.addAttribute("producto", pruducto);
		model.addAttribute("titulo", tituloCrear);
		model.addAttribute("isAccionCrear", true);
		
		return "productos/form";
	}
	
	@PostMapping("/productos/crear")
	public String crearProductos(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("producto", producto);
			model.addAttribute("titulo", tituloCrear);
			model.addAttribute("isAccionCrear", true);
			
			return "productos/form";
		}
		
		this.productoService.guardarProducto(producto);
		status.setComplete();
		
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/editar/{id}")
	public String editarProducto(@PathVariable(value = "id") Long id, Model model) {
		Producto producto = null;
		
		if(null != id && id > 0) {
			producto = this.productoService.buscarProductoPorId(id);
		}else {
			return "redirect:/productos";
		}
		
		model.addAttribute("producto", producto);
		model.addAttribute("titulo", tituloEditar);
		model.addAttribute("isAccionCrear", false);
		
		return "productos/form";
	}
	
	
	@PostMapping("/productos/editar")
	public String editarProducto(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("producto", producto);
			model.addAttribute("titulo", tituloEditar);
			model.addAttribute("isAccionCrear", false);
			
			return "productos/form";
		}
		
		this.productoService.editarProducto(producto);
		status.setComplete();
		
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value = "id") Long id) {
		if(null != id && id > 0) {
			this.productoService.eliminarProducto(id);
		}
		
		return "redirect:/productos";
		
	}
	
}
