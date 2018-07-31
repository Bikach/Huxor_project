package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public  abstract class Users implements Serializable {

	private static final long serialVersionUID = -9125319231283171487L;

	@Id
	@GeneratedValue
	private long idUser;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String password;
	private String firstName;
	private String lastName;
	@NotNull
	private boolean enabled;


	/**
	 * Default constructor
	 */
	public Users() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param lasName
	 * @param firstName
	 * @param enabled

	 */
	public Users( String email, String password, String lasName, String firstName, boolean enabled) {
		this.email = email;
		this.password = password;
		this.lastName = lasName;
		this.firstName = firstName;
		this.enabled = enabled;
	}

	// ===== Getters & Setters =====//

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lasName) {
		this.lastName = lasName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
