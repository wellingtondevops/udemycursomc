package com.wellingtondevops.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellingtondevops.cursomc.domain.Pedido;
import com.wellingtondevops.cursomc.repositories.PedidoRepository;
import com.wellingtondevops.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Pedido obj= repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: "
		+ Pedido.class.getName());
		}
		return obj;			
		
	}

}
