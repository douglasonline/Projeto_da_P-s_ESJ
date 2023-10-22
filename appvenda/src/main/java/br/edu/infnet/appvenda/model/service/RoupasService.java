package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Roupas;

@Service
public class RoupasService {

	private Map<Integer, Roupas> mapaRoupas = new HashMap<Integer, Roupas>();

	public void incluir(Roupas roupas) {
		mapaRoupas.put(roupas.getCodigo(), roupas);
	}
	
	public Collection<Roupas> obterLista(){	
		return mapaRoupas.values();
	}
}