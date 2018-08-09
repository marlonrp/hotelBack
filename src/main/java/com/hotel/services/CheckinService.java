package com.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Checkin;
import com.hotel.repositories.CheckinRepository;
import com.hotel.services.exceptions.ObjectNotFoundException;

@Service
public class CheckinService {

	@Autowired
	private CheckinRepository cRepository;
	
	public List<Checkin> findAll(){
		
		return cRepository.findAll();
	}
	
	public void save(Checkin checkin) {
		
		cRepository.save(checkin);
	}
	
	public Optional<Checkin> findById(Integer id) {
		Optional<Checkin> obj = cRepository.findById(id);
		
		if(!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto id: " + id + " não foi encontrado!");
		}
		return obj;
	}
}