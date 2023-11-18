package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.InformacaoService;
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
	@Autowired
	private InformacaoService informacaoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("informacoes", informacaoService.obterLista());
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeRoupas", roupasService.obterQtde());
		model.addAttribute("qtdeSapatos", sapatosService.obterQtde());

		return "home";
	}
}