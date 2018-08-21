package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Categorys implements Serializable {

	private static final long serialVersionUID = 7628499725672325408L;

	@Id
	@NotNull
	private String category;
	private String describtion;

	/**
	 * Default constructor
	 */
	public Categorys() {
	}

	/**
	 * Constructor with parameter
	 * 
	 * @param category
	 */
	public Categorys(String category) {
		super();
		this.category = category;
	}

	// ===== Getters & Setters =====//

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	
}
