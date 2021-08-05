package com.yomyom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yomyom.model.Perfil;
import com.yomyom.service.IntPerfilesService;

@Controller
@RequestMapping("/perfiles")
public class PerfilesController {
	
	@Autowired
	private IntPerfilesService perfilesService;
	
	public String buscar(@RequestParam("id") int idPerfil,
			Model model) {
		Perfil per = perfilesService.buscarPorId(idPerfil);
		model.addAttribute("perfil", per);
		return "perfiles/formPerfil";
	}
	
	@PostMapping("/guardar")
	public String guardar(Perfil per) {
		perfilesService.guardar(per);
		return "redirect:/perfiles/index";

	}
	
	@GetMapping("/crear")
	public String crear(Perfil per) {
		return "perfiles/formPerfil";
	}
	
	@GetMapping("/detalles")
	public String detalles(@RequestParam("id") int idPerfiles,
			Model model) {
		System.out.println("idPerfiles : " + idPerfiles);
		model.addAttribute("perfil", perfilesService.buscarPorId(idPerfiles));
		return "perfiles/detalles";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idPerfil,
			RedirectAttributes atributo) {
		perfilesService.eliminar(idPerfil);
		atributo.addFlashAttribute("msg", "Perfil eliminado con exito");
		return "redirect:/perfiles/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Perfil> perfiles = perfilesService.obtenerTodas();
		model.addAttribute("perfiles", perfiles);
		return "perfiles/listaPerfiles";
	}
}
