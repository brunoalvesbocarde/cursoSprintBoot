package com.bruno.cursoMc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.cursoMc.domain.Categoria;
import com.bruno.cursoMc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired // isntacia automatico
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // recebe um id como busca
	public ResponseEntity<?> find(@PathVariable Integer id) { // para que o mesmo id do resquestmap seja igual
		// responseEtity ja retorna como https (web mais bonitinho)

		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
