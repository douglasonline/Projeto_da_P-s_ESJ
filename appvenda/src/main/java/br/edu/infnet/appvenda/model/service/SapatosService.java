package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Sapatos;

@Service
public class SapatosService {

	private Map<Integer, Sapatos> mapaSapatos = new HashMap<Integer, Sapatos>();

	public void incluir(Sapatos sapatos) {
		mapaSapatos.put(sapatos.getCodigo(), sapatos);
	}
	
	public Collection<Sapatos> obterLista(){	
		return mapaSapatos.values();
	}
}