package com.neliosalves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neliosalves.cursomc.domain.Cliente;
import com.neliosalves.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Cliente> find(@PathVariable("id") Integer id) {
		
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
