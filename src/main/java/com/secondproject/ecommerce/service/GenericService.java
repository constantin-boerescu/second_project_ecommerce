package com.secondproject.ecommerce.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.*;

public abstract class GenericService<T, ID> {
	
	private final JpaRepository<T, ID> repository;
	
	protected GenericService(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}
	
	@Transactional
	public T save(T entity) {
		return repository.save(entity);
	}
	
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}
	
}
