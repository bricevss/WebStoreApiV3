package com.m2i.WebStoreApiV3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {

	@Id @GeneratedValue( strategy = GenerationType.SEQUENCE)
	private int id;
	
	protected float amount;
	protected java.util.Date paymentDate;
	
	@OneToOne @JoinColumn(name="idCommand")
	private Command command;

}
