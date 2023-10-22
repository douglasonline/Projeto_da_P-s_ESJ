package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Sapatos;
import br.edu.infnet.appvenda.model.service.SapatosService;

@Order(4)
@Component
public class SapatosLoader implements ApplicationRunner {
	
	@Autowired
	private SapatosService sapatosService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/sapatos.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Sapatos sapatos = new Sapatos();

			sapatos.setCodigo(Integer.valueOf(campos[0]));
			sapatos.setDescricao(campos[1]);
			sapatos.setEstoque(Boolean.valueOf(campos[2]));
			sapatos.setPreco(Float.valueOf(campos[3]));
			sapatos.setTipo(campos[4]);
			sapatos.setCor(campos[5]);
			
			sapatosService.incluir(sapatos);
			
			linha = leitura.readLine();
		}

		for(Sapatos sapatos : sapatosService.obterLista()) {
			System.out.println("[Sapatos] " + sapatos);
		}
		
		leitura.close();
	}
}