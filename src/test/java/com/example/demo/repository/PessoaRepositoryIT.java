package com.example.demo.repository;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.Pessoa;

@SpringBootTest
@ActiveProfiles("ci")
@RunWith(SpringJUnit4ClassRunner.class)
public class PessoaRepositoryIT {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Before
	public void setUp() {
		pessoaRepository.deleteAll();
	}

	@After
	public void tearDown() {
		pessoaRepository.deleteAll();
	}

	@Test
	public void testSave() {

		Pessoa pessoa = new Pessoa(null, "Nome", "foo@bar", LocalDate.now());

		pessoaRepository.save(pessoa);
	}

}
