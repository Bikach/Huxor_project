package fr.huxor.entities;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name="CODE_USER")
@DiscriminatorValue("MA")
public class Managers extends Users {

	private static final long serialVersionUID = -7942635791750160132L;

	@NotNull
	private String registrationNumber;

	/**
	 * Default constructor
	 */
	public Managers() { 
		super();
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param username (Users)
	 * @param email (Users)
	 * @param password (Users)
	 * @param lasName (Users)
	 * @param firstName (Users)
	 * @param enabled (Users)
	 * @param registrationNumber
	 */
	public Managers(String username, String email, String password, String lasName, String firstName, boolean enabled,
			String registrationNumber, Set<Role> roles) {
		super(username, email, password, lasName, firstName, enabled, roles);
		this.registrationNumber = registrationNumber;
	} 

	// ===== Getters & Setters =====//

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
