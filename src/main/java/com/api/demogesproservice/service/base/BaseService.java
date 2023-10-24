package com.api.demogesproservice.service.base;

import java.util.List;

import jakarta.persistence.Entity;

public interface BaseService<E> {
	public List<E> findAll() throws Exception;
	public E findById(Long id) throws Exception;
	public E save(E entity) throws Exception;
	public E update(Long id, E entity) throws Exception;
	public boolean delete (Long id) throws Exception;
}
