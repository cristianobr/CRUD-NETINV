package br.com.cristianobr.netinv.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Elemento {
	
	@Id @GeneratedValue
	private Long id;
	private String serial;
	private String modelo;
	private String vendor;
	
	

}
