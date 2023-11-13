package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Roupas;
import br.edu.infnet.appvenda.model.repository.RoupasRepository;

@Service
public class RoupasService {
	
	@Autowired
	private RoupasRepository roupasRepository;

	public void incluir(Roupas roupas) {
		roupasRepository.save(roupas);
	}
	
	public Collection<Roupas> obterLista(){	
		return (Collection<Roupas>) roupasRepository.findAll();
	}
	
	public long obterQtde() {
		return roupasRepository.count();
	}
}