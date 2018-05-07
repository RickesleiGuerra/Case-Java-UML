package com.java.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uml.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category,Integer>{

	
}
