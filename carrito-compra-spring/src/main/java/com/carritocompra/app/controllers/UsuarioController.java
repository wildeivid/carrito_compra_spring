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

import com.carritocompra.app.models.entity.Usuario;
import com.carritocompra.app.models.service.IUsuarioService;


@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Value("${plantilla.usuarios.form.editar.titulo}")
	private String tituloEditar;
	
	@Value("${plantilla.usuarios.form.crear.titulo}")
	private String tituloCrear;
	
	
	@GetMapping("/usuarios")
	public String verUsuarios(Model model) {
		model.addAttribute("usuarios", this.usuarioService.listarUsuarios());
		
		return "usuarios/ver";
	}
	
	@GetMapping("/usuarios/crear")
	public String crearUsuarios(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", tituloCrear);
		model.addAttribute("isAccionCrear", true);
		
		return "usuarios/form";
	}
	
	@PostMapping("/usuarios/crear")
	public String crearUsuarios(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", tituloCrear);
			model.addAttribute("isAccionCrear", true);
			
			return "usuarios/form";
		}
		
		this.usuarioService.guardarUsuario(usuario);
		status.setComplete();
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String editarUsuario(@PathVariable(value = "id") Long id, Model model) {
		Usuario usuario = null;
		
		if(null != id && id > 0) {
			usuario = this.usuarioService.buscarUsuarioPorId(id);
		}else {
			return "redirect:/usuarios";
		}
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", tituloEditar);
		model.addAttribute("isAccionCrear", false);
		
		return "usuarios/form";
	}
	
	
	@PostMapping("/usuarios/editar")
	public String editarUsuario(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", tituloEditar);
			model.addAttribute("isAccionCrear", false);
			
			return "usuarios/form";
		}
		
		this.usuarioService.editarUsuario(usuario);
		status.setComplete();
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value = "id") Long id) {
		if(null != id && id > 0) {
			this.usuarioService.eliminarUsuario(id);
		}
		
		return "redirect:/usuarios";
		
	}
	
}
