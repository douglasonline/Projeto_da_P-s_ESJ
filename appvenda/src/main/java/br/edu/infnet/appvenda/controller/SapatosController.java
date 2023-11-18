package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.SapatosService;

@Controller
public class SapatosController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private SapatosService sapatosService;

	
	@GetMapping(value = "/sapatos/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "sapatos");
		model.addAttribute("titulo", "Sapatos:");
		model.addAttribute("listagem", sapatosService.obterLista());

		return appController.showHome(model);
	}
	

	@GetMapping(value = "/sapatos/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		sapatosService.excluir(id);
		
		return "redirect:/sapatos/lista";
	}
}