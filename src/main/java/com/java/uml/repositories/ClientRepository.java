package com.java.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uml.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client,Integer>{

	
}
