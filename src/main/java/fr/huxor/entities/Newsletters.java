package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Newsletters implements Serializable {

	private static final long serialVersionUID = -9209276475373038017L;

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private long idNewsletter;
	@Email
	private String email;

	/**
	 * Default constructor
	 */
	public Newsletters() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param email
	 */
	public Newsletters(String email) {
		this.email = email;
	}

	// ===== Getters & Setters =====//

	public long getIdNewsletter() {
		return idNewsletter;
	}

	public void setIdNewsletter(long idNewsletter) {
		this.idNewsletter = idNewsletter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
