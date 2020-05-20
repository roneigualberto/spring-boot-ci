package com.example.demo.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.domain.Pessoa;
import com.example.demo.service.PessoaService;

@RunWith(MockitoJUnitRunner.class)
public class PessoaControllerTest {

	@InjectMocks
	private PessoaController pessoaController;

	private MockMvc mockMvc;

	@Mock
	private PessoaService pessoaService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(pessoaController).build();
	}
	
	@Test
    public void testFindAll() throws Exception {
		
		Pessoa pessoa1 = new Pessoa(1L, "Pessoa1", "pessoa1@email.com", LocalDate.of(1991, Month.APRIL, 16));
		
		Pessoa pessoa2 = new Pessoa(2L, "Pessoa2", "pessoa2@email.com", LocalDate.of(1980, Month.MAY, 21));
		List<Pessoa> pessoas = Arrays.asList(pessoa1,pessoa2);
		
        given(pessoaService.findAll()).willReturn(pessoas);

        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/pessoas")
                .contentType(MediaType.APPLICATION_JSON))
        		.andReturn()
        		.getResponse();
        
        
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }


}
