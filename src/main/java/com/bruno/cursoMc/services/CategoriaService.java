package com.bruno.cursoMc.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.cursoMc.domain.Categoria;
import com.bruno.cursoMc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired // ele instacia automaticamente o obj
	
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) { // busca no banco e retorna o obj  
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); // se nao achao o obj retorna null 
		}
}
