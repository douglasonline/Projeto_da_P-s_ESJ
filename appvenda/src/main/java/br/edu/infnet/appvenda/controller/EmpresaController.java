package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.EmpresaService;

@Controller
public class EmpresaController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private EmpresaService empresaService;


	@GetMapping(value = "/empresa/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "empresa");
		model.addAttribute("titulo", "Empresas:");
		model.addAttribute("listagem", empresaService.obterLista());

		return appController.showHome(model);
	}
	
	@GetMapping(value = "/empresa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		empresaService.excluir(id);
		
		return "redirect:/empresa/lista";
	}
}