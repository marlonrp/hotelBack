package com.hotel.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Pessoa;
import com.hotel.services.PessoaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<Pessoa> conteudo = pService.findAll();		
		return ResponseEntity.ok().body(conteudo);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findOneById(@PathVariable Integer id){
		Optional<Pessoa> t = pService.findById(id);
		return ResponseEntity.ok().body(t);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Pessoa pessoa){
		pService.save(pessoa);
		return ResponseEntity.ok().body("Cliente salvo");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> save(@PathVariable Integer id, @RequestBody Pessoa pessoa){
		
		pService.save(pessoa);
		return ResponseEntity.ok().body("Cliente alterado");
	}
}