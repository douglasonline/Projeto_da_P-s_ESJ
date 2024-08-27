package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
