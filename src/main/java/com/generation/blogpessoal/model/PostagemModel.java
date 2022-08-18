package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Essa classe é uma entidade.
@Table(name = "tb_postagens") // Dentro do banco de dados essa entidade vai virar uma tabela.
public class PostagemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto_increment. O id será transformado em uma primary key.
	private Long id;

	@NotBlank(message = "O atributo título é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;

	@NotNull(message = "O atributo texto é obrigatório!") // Não pode ser um campo vazio.
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;

	@UpdateTimestamp // Informa JPA que estamos trabalhando com tempo atual da máquina.
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema; // Criando o campo "tema" para receber a chave estrangeira. Como se fosse o
							// categoria_id do MySQL.

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UsuarioModel usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

}
