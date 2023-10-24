package com.api.demogesproservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demogesproservice.entity.Cliente;
import com.api.demogesproservice.repository.ClienteRepository;
import com.api.demogesproservice.service.base.BaseService;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@Service
public class ClienteService implements BaseService<Cliente>{

	//--------INYECCION DE DEPENDECIAS----------------------//
	 
	@Autowired
	private ClienteRepository clienteRepository;
	
	//------------------------------------------------------//
	
	@Override
	@Transactional
	public List<Cliente> findAll() throws Exception {
		try {
			List<Cliente> entities = clienteRepository.findAll();
			return entities;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Cliente findById(Long id) throws Exception {
		try {
			Optional<Cliente> entityOptional = clienteRepository.findById(id);
			return entityOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Cliente save(Cliente entity) throws Exception {
		try {
			entity = clienteRepository.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Cliente update(Long id, Cliente entity) throws Exception {
		try {
			Optional<Cliente> entityOptional = clienteRepository.findById(id);
			Cliente entityUpdate = entityOptional.get();
			entityUpdate = clienteRepository.save(entity);
			return entityUpdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if (clienteRepository.existsById(id)) {
				clienteRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


}
