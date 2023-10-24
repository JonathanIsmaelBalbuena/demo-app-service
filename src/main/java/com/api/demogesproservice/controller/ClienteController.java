package com.api.demogesproservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.demogesproservice.entity.Cliente;
import com.api.demogesproservice.service.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/clientes")
public class ClienteController {
	
//-------------------------INYECCION DE DEPENDECIAS------//	 
	@Autowired
	private ClienteService clienteService;
//------------------------------------------------------//

	@GetMapping("/getHi")
	public ResponseEntity<?> getSaludo() {
		try {
			String saludo = "Hola Johann";
			return ResponseEntity
						.status(HttpStatus.OK)
						.body(saludo);
		} catch (Exception e) {
			return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("{\"error\":\"Error. Por favor intente nuevamente.\"}");
		}
	}	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity
						.status(HttpStatus.OK)
						.body(clienteService.findAll());
		} catch (Exception e) {
			return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity
						.status(HttpStatus.OK)
						.body(clienteService.findById(id));
		} catch (Exception e) {
			return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Cliente entity) {
		try {
			return ResponseEntity
						.status(HttpStatus.OK)
						.body(clienteService.save(entity));
		} catch (Exception e) {
			return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente entity) {
		try {
			return ResponseEntity
						.status(HttpStatus.OK)
						.body(clienteService.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(clienteService.delete(id));
		} catch (Exception e) {
			return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}		
	
}
