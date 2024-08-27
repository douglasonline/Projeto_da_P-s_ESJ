package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.clients.IEnderecoClient;
import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Empresa;
import br.edu.infnet.appvenda.model.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public void incluir(Empresa empresa) {
		
		Endereco endereco = enderecoClient.buscarCep(empresa.getEndereco().getCep());
		
		empresa.setEndereco(endereco);
		
		empresaRepository.save(empresa);
	}
	
	public void excluir(Integer id) {
		
		empresaRepository.deleteById(id);
		
	}
	
	public Collection<Empresa> obterLista(){
		return (Collection<Empresa>) empresaRepository.findAll();
	}
	
	public long obterQtde() {
		return empresaRepository.count();
	}

}