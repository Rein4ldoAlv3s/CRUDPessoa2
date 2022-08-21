package com.reinaldo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Pessoa;
import com.reinaldo.repositories.PessoaRepository;

@SpringBootApplication
public class CrudPessoa2Application implements CommandLineRunner{

	@Autowired
	private PessoaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudPessoa2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "Reinaldo Alves", "887.430.140-54", "(62) 99549-0185");
		Pessoa p2 = new Pessoa(null, "Luana Guimarães", "157.808.040-10", "(62) 99755-7822");
		Pessoa p3 = new Pessoa(null, "Gusttavo Lima", "806.812.200-15", "(62) 92788-7911");
		
		List<Pessoa> list = Arrays.asList(p1,p2,p3);
		
		repo.saveAll(list);
	}

}
