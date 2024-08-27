package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

import br.edu.infnet.appvenda.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	
	@Query("from Produto p WHERE p.empresa.id = :vendedorId")
	Collection<Produto> obterLista(Integer vendedorId);

}
