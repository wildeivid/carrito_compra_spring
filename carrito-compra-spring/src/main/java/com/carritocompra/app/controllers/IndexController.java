package com.carritocompra.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carritocompra.app.models.entity.Usuario;
import com.carritocompra.app.models.service.IUsuarioService;

@Controller
public class IndexController {
	
	private Usuario usuario;
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping({"/", ""})
	public String index(Model model, HttpSession session) {
		this.usuario = this.iUsuarioService.buscarUsuarioPorId(Long.valueOf(1));
		session.setAttribute("usuario", this.usuario);
		
		return "index";
	}
}
