package com.api.demogesproservice.entity;

import com.api.demogesproservice.entity.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntity {

	private static final long serialVersionUID = 1722520993504413611L;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;

	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="num_documento")
	private String numDocumento;
	/*
	@Column(name="cliente_activo")
	private boolean clienteActivo;
	*/
	
	
	// GETTERS & SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}	

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	/*
	public boolean isClienteActivo() {
		return clienteActivo;
	}

	public void setClienteActivo(boolean clienteActivo) {
		this.clienteActivo = clienteActivo;
	}
	*/
}
