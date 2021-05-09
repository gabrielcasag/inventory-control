package com.gabrielcasag.estoque.apirest.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class ProdutosResourceTest {

	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	
	@BeforeEach
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testaRequisicaoBuscaProdutosSucesso() throws Exception{
		String url = "/api/produtos";
		
		this.mvc.perform(get(url))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testaRequisicaoInexistente() throws Exception{
		String url = "/api/produto";
		
		this.mvc.perform(get(url))
		.andExpect(status().isMethodNotAllowed());
	}
}
