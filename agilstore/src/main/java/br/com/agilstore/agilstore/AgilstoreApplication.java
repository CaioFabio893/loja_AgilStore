package br.com.agilstore.agilstore;

import br.com.agilstore.agilstore.principal.Principal;
import br.com.agilstore.agilstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgilstoreApplication implements CommandLineRunner {
	@Autowired
	private ProdutoRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(AgilstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
