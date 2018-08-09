package com.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Pessoa;
import com.hotel.repositories.PessoaRepository;
import com.hotel.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pRepository;
	
	public List<Pessoa> findAll(){
		
		return pRepository.findAll();
	}
	
	public void save(Pessoa pessoa) {
		
		pRepository.save(pessoa);
	}
	
	public Optional<Pessoa> findById(Integer id) {
		Optional<Pessoa> obj = pRepository.findById(id);
		
		if(!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto id: " + id + " não foi encontrado!");
		}
		return obj;
	}
}