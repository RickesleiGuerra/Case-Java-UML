package com.java.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uml.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository <Request,Integer>{

	
}
