package com.angela.myapi;

import com.angela.myapi.domain.Usuario;
import com.angela.myapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Angela Luiz", "angela", "123456");
		Usuario u2 = new Usuario(null, "Rodrigo Luiz", "rodrigo", "123456");

		usuarioRepository.saveAll(Arrays.asList(u1, u2));

	}
}
