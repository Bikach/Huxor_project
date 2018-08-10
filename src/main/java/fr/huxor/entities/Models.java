package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Models implements Serializable {

	private static final long serialVersionUID = -1879785430919026789L;

	@Id
	@NotNull
	private String modelName;

	/**
	 * Default constructor
	 */
	public Models() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param modelName
	 */
	public Models(String modelName) {
		this.modelName = modelName;
	}

	// ===== Getters & Setters =====//

	
	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
