package com.senai.anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.anna.domain.Endereco;
import com.senai.anna.repositories.EnderecoRepository;

@SpringBootTest

public class enderecoTest {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Test
	void Endereco() {
		Endereco e1 = new Endereco();
		e1.setIdEndereco(1);
		e1.setBairro("Santa Mônica");
		e1.setCep("38407569");
		e1.setLogradouro("Rua");
		e1.setComplemento("Prédio");
		enderecoRepository.save(e1);

	}

	@Test
	public void listaEndereco() {
		List<Endereco> List = enderecoRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idEndereco() {
		Endereco endereco = enderecoRepository.findById(1).get();
		assertEquals("Santa Mônica", endereco.getBairro());
	}

	@Test
	public void updateEndereco() {
		Endereco endereco = enderecoRepository.findById(1).get();
		endereco.setBairro("Santa Mônica");
		enderecoRepository.save(endereco);
		assertNotEquals("Santa Mônica", endereco.getBairro());
	}

	@Test
	public void DeleteEndereco() {
		enderecoRepository.deleteById(1);
		assertThat(enderecoRepository.existsById(1));
	}

	@Test
	public void somar() {
		double num1 = 10.0;
		double num2 = 2.0;
		Endereco endereco = new Endereco();
		double soma = endereco.somar(num1, num2);
		assertEquals(12, soma);
	}
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Endereco endereco = new Endereco();
		double subtrair = endereco.subtracao(num1, num2);
		assertEquals(8, subtrair);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Endereco endereco = new Endereco();
		double multiplicar = endereco.multiplicacao(num1, num2);
		assertEquals(20, multiplicar);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Endereco endereco = new Endereco();
		double dividir = endereco.divisao(num1, num2);
		assertEquals(5, dividir);
	}
}