package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Roupas;
import br.edu.infnet.appvenda.model.domain.Sapatos;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[6]) {
			case "R":
				Roupas roupas = new Roupas();
				roupas.setCodigo(Integer.valueOf(campos[0]));
				roupas.setDescricao(campos[1]);
				roupas.setEstoque(Boolean.valueOf(campos[2]));
				roupas.setPreco(Float.valueOf(campos[3]));
				roupas.setTipo(campos[4]);
				roupas.setCor(campos[5]);
				
				produtoService.incluir(roupas);
				
				break;

			case "S":
				Sapatos sapatos = new Sapatos();
				sapatos.setCodigo(Integer.valueOf(campos[0]));
				sapatos.setDescricao(campos[1]);
				sapatos.setEstoque(Boolean.valueOf(campos[2]));
				sapatos.setPreco(Float.valueOf(campos[3]));
				sapatos.setTipo(campos[4]);
				sapatos.setCor(campos[5]);
				
				produtoService.incluir(sapatos);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		leitura.close();
	}
}