package br.com.cristianobr.netinv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cristianobr.netinv.model.Elemento;
import br.com.cristianobr.netinv.repo.ElementoRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class ElementoController {
	
	
	@Autowired
	private ElementoRepo elementRepo;
	
	@GetMapping("/elementos")
	public List<Elemento> Listar() {
		return elementRepo.findAll();
	}
		
	@PostMapping("/elemento")
	public void incluir(@RequestBody Elemento elemento) {
		elementRepo.save(elemento);
	}
	
	@PutMapping("/elemento")
	public void alterar(@RequestBody Elemento elemento){
		elementRepo.save(elemento);
	}

	@DeleteMapping("/elemento")
	public void deletar(@RequestBody Elemento elemento){
		elementRepo.delete(elemento);
	}

	@GetMapping("/elemento/{id}")
	public Optional<Elemento> ler(@PathVariable Long id){
		return elementRepo.findById(id);
	}


	

}
