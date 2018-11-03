package com.wellingtondevops.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellingtondevops.cursomc.domain.Pedido;;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	Pedido findOne(Integer id);
	
	
	

}
