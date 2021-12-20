package com.senai.anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.anna.domain.Estado;
import com.senai.anna.repositories.EstadoRepository;

@SpringBootTest
public class estadoTest {
	@Autowired
	EstadoRepository estadoRepository;

	@Test
	void Estado() {
		Estado est1 = new Estado();
		est1.setId(null);
		;
		est1.setNome("São Paulo");
		est1.setCidades(null);
		estadoRepository.save(est1);
	}

	@Test
	public void listaEstado() {
		List<Estado> List = estadoRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idEstado() {
		Estado estado = estadoRepository.findById(1).get();
		assertEquals("São Paulo", estado.getNome());
	}

	@Test
	public void updateEstado() {
		Estado estado = estadoRepository.findById(1).get();
		estado.setNome("São Paulo");
		estadoRepository.save(estado);
		assertNotEquals("SP", estado.getNome());
	}

	@Test
	public void deleteEstado() {
		estadoRepository.deleteById(1);
		assertThat(estadoRepository.existsById(1));
	}

	@Test
	public void somar() {
		double num1 = 10.0;
		double num2 = 2.0;
		Estado estado = new Estado();
		double soma = estado.somar(num1, num2);
		assertEquals(12, soma);
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Estado estado = new Estado();
		double subtrair = estado.subtracao(num1, num2);
		assertEquals(8, subtrair);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Estado estado = new Estado();
		double multiplicar = estado.multiplicacao(num1, num2);
		assertEquals(20, multiplicar);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 2.0;
		Estado estado = new Estado();
		double dividir = estado.divisao(num1, num2);
		assertEquals(5, dividir);
	}
}