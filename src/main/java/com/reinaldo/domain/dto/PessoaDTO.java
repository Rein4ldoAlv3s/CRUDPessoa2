package com.reinaldo.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.reinaldo.domain.Pessoa;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "NÃO PODE SER NULO!")
	private String nome;
	@CPF
	@NotEmpty(message = "NÃO PODE SER NULO!")
	private String cpf;
	@NotEmpty(message = "NÃO PODE SER NULO!")
	private String telefone;

	public PessoaDTO() {
		super();
	}

	public PessoaDTO(Pessoa obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
