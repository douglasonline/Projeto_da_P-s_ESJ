package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import br.edu.infnet.appvenda.model.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.service.EmpresaService;

@Order(1)
@Component
public class EmpresaLoader implements ApplicationRunner {
	
	@Autowired
	private EmpresaService empresaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/empresa.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Empresa empresa = new Empresa();
			
			empresa.setRazaoSocial(campos[0]);
			empresa.setCnpj(campos[1]);
			empresa.setGmail(campos[2]);
			empresa.setEndereco(new Endereco(campos[3]));
			
			try {
				empresaService.incluir(empresa);
			} catch(ConstraintViolationException e) {
				//System.out.println("[EMPRESA] " + empresa);
				FileLogger.logException("[EMPRESA] " + empresa + " - " + e.getMessage());
			}
			
									
			linha = leitura.readLine();
		}

		for(Empresa empresa : empresaService.obterLista()) {
			System.out.println("[Empresa] " + empresa);
		}
		
		leitura.close();
	}
}