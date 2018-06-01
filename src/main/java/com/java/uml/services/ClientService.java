package com.java.uml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.uml.domain.Client;
import com.java.uml.repositories.ClientRepository;
import com.java.uml.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+ id +", type: " + Client.class.getName()));
	}
}
