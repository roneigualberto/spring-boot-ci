package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "/api/v1/pessoas")
	public List<Pessoa> findAll() {

		return this.pessoaService.findAll();
	}

}
