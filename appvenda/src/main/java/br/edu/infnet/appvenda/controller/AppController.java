package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.RoupasService;
import br.edu.infnet.appvenda.model.service.SapatosService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private RoupasService roupasService;
	@Autowired
	private SapatosService sapatosService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeRoupas", roupasService.obterQtde());
		model.addAttribute("qtdeSapatos", sapatosService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/roupas/lista")
	public String obterListaRoupas(Model model) {
		
		model.addAttribute("titulo", "Produtos Roupas:");
		model.addAttribute("listagem", roupasService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/sapatos/lista")
	public String obterListaSapatos(Model model) {
		
		model.addAttribute("titulo", "Produtos Sapatos:");
		model.addAttribute("listagem", sapatosService.obterLista());

		return showHome(model);
	}
}