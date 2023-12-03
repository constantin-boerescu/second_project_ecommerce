package com.secondproject.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.secondproject.ecommerce.service.GenericService;

public abstract class GenericController<T, ID> {
	
	private final GenericService<T, ID> genericService;
	
	protected GenericController(GenericService<T, ID> genericService) {
		this.genericService = genericService;
	}
	
	@GetMapping
	public ResponseEntity<List<T>> getAll() {
		return ResponseEntity.ok(genericService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> getById(@PathVariable ID id) {
		
	    Optional<T> foundEntity = genericService.findById(id);
	    if (foundEntity.isPresent()) {
	        return ResponseEntity.ok(foundEntity.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping
	public ResponseEntity<T> create(@RequestBody T entity) {
		return ResponseEntity.ok(genericService.save(entity));
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        genericService.deleteById(id);
        return ResponseEntity.ok().build();
    }
	

	
	
}
