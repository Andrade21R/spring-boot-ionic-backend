package com.neliosalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neliosalves.cursomc.domain.Pedido;
import com.neliosalves.cursomc.repositories.PedidoRepository;
import com.neliosalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Pedido find(@PathVariable("id") Integer id) {
		
		Optional<Pedido> obj = pedidoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}

}
