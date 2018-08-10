package com.hotel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Checkin implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="id_pessoa")
	private Integer idPessoa;
	
	@Column(name="data_entrada")
	private String dataEntrada;
	
	@Column(name="data_saida")
	private String dataSaida;
	
	@Column(name="possui_veiculo")
	private boolean possuiVeiculo;
	
	private boolean finalizado;
}
