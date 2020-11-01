package com.carritocompra.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("tituloPrincipal", "");
		return "admin/index";
	}
	
}
