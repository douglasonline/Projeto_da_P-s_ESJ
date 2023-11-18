package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.RoupasService;

@Controller
public class RoupasController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private RoupasService roupasService;


	@GetMapping(value = "/roupas/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "roupas");
		model.addAttribute("titulo", "Roupas:");
		model.addAttribute("listagem", roupasService.obterLista());

		return appController.showHome(model);
	}
	
	@GetMapping(value = "/roupas/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		roupasService.excluir(id);
		
		return "redirect:/roupas/lista";
	}
}