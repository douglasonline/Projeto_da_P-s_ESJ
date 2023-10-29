package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Roupas;

@Repository
public interface RoupasRepository extends CrudRepository<Roupas, Integer> {

}
