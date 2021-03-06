package com.java.uml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.uml.domain.Category;
import com.java.uml.repositories.CategoryRepository;
import com.java.uml.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+ id +", type: " + Category.class.getName()));
	}
	
	public Category insert (Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
