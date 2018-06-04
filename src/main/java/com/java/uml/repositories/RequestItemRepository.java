package com.java.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uml.domain.RequestItem;

@Repository
public interface RequestItemRepository extends JpaRepository <RequestItem,Integer>{

	
}
