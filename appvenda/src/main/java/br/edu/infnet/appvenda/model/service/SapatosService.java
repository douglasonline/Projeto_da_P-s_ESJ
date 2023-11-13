package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appvenda.model.domain.Sapatos;
import br.edu.infnet.appvenda.model.repository.SapatosRepository;

@Service
public class SapatosService {

	@Autowired
	private SapatosRepository sapatosRepository;

	public void incluir(Sapatos sapatos) {
		sapatosRepository.save(sapatos);
	}
	
	public Collection<Sapatos> obterLista(){	
		return (Collection<Sapatos>) sapatosRepository.findAll();
	}
	
	public long obterQtde() {
		return sapatosRepository.count();
	}
}