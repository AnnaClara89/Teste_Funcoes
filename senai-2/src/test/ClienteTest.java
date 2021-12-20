package com.senai.anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.anna.domain.Cliente;
import com.senai.anna.repositories.ClienteRepository;

@SpringBootTest

public class clienteTest {

	@Autowired
	ClienteRepository clienteRepository;

	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Anna Clara");
		cli.setCpfOuCnpj("65541239874");
		cli.setEmail("annaclara89@gmail.com");
		clienteRepository.save(cli);
	}

	@Test
	public void listaCliente() {
		List<Cliente> List = clienteRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		assertEquals("Anna Clara", cliente.getNome());
	}

	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		cliente.setNome("Anna Clara");
		clienteRepository.save(cliente);
		assertNotEquals("Anna", cliente.getNome());
	}

	@Test
	public void deleteCliente() {
		clienteRepository.deleteById(1);
		assertThat(clienteRepository.existsById(1));
	}

	@Test
	public void somar() {
		double num1 = 10.0;
		double num2 = 2.0;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(12, soma);
	}
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Cliente cliente = new Cliente();
		double subtrair = cliente.subtracao(num1, num2);
		assertEquals(8, subtrair);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Cliente cliente = new Cliente();
		double multiplicar = cliente.multiplicacao(num1, num2);
		assertEquals(20, multiplicar);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Cliente cliente = new Cliente();
		double dividir = cliente.divisao(num1, num2);
		assertEquals(5, dividir);
	}
	

}