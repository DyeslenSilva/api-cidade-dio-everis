package br.com.dio.citiesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pais")
@NoArgsConstructor
public class Country {

	@Id
	private Long id;
	
	@Column(name = "name")
	private String nome;
	
	@Column(name = "portugueseName")
	private String portugueseName;
	
	@Column(name = "code")
	private String code;
	
	
	private Integer bacen;
}
