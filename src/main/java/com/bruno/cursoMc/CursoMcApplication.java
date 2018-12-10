package com.bruno.cursoMc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.cursoMc.domain.Categoria;
import com.bruno.cursoMc.domain.Produto;
import com.bruno.cursoMc.repositories.CategoriaRepository;
import com.bruno.cursoMc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository ;	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impessora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3)); // adicionei os produtos em suas categorias 
		cat2.getProdutos().addAll(Arrays.asList(p1));
		
		p1.getCategorias().addAll(Arrays.asList(cat1)); // mostrei de qual categoria é de qual produto de acordo com a associação 
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3 .getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2)); // salvando as categorias no banco de dados
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));    // salvando todos os produtos 
		
	}
}
