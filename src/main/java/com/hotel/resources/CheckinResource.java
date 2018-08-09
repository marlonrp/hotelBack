package com.hotel.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Checkin;
import com.hotel.services.CheckinService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/checkins")
public class CheckinResource {

	@Autowired
	private CheckinService cService;
	
	//@CrossOrigin(value="http://localhost:4200")
	//@CrossOrigin(value="http://pcbnu010971:8080")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<Checkin> conteudo = cService.findAll();		
		return ResponseEntity.ok().body(conteudo);
	}
	
	//@CrossOrigin(value="http://localhost:4200")
	//@CrossOrigin(value="http://pcbnu010971:8080")
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findOneById(@PathVariable Integer id){
		Optional<Checkin> t = cService.findById(id);
		return ResponseEntity.ok().body(t);
	}
}