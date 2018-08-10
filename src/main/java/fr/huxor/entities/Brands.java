package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Brands implements Serializable {

	private static final long serialVersionUID = 7364026866652714040L;
	
	@Id
	@NotNull
	private String brandName;

	/**
	 * Default constructor
	 */
	public Brands() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param modelName
	 */
	public Brands(String brandName) {
		this.brandName = brandName;
	}

	// ===== Getters & Setters =====//
	
	public String getlBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
