package com.neliosalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neliosalves.cursomc.domain.enums.EstadoPagamento;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	
	private Integer estado;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	
	@JsonIgnore
	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}
	
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}


	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}
	
	
	
}
