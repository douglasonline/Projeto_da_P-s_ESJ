package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Roupas;
import br.edu.infnet.appvenda.model.domain.Empresa;
import br.edu.infnet.appvenda.model.service.RoupasService;

@Order(3)
@Component
public class RoupasLoader implements ApplicationRunner {
	
	@Autowired
	private RoupasService roupasService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/roupas.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Roupas roupas = new Roupas();

			roupas.setCodigo(Integer.valueOf(campos[0]));
			roupas.setDescricao(campos[1]);
			roupas.setEstoque(Boolean.valueOf(campos[2]));
			roupas.setPreco(Float.valueOf(campos[3]));
			roupas.setTipo(campos[4]);
			roupas.setCor(campos[5]);
			
			Empresa empresa = new Empresa();
			empresa.setId(Integer.valueOf(campos[6]));
			
			roupas.setEmpresa(empresa);
			
			roupasService.incluir(roupas);
			
			linha = leitura.readLine();
		}

		for(Roupas roupas: roupasService.obterLista()) {
			System.out.println("[Roupas] " + roupas);			
		}

		leitura.close();
	}
}