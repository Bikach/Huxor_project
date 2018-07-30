package fr.huxor.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("MA")
public class Managers extends Users {

	private static final long serialVersionUID = -7942635791750160132L;

	@NotNull
	private String registrationNumber;
	@OneToOne
	@JoinColumn(name = "CODE_USER")
	private Users user;

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
	 * @param user
	 */
	public Managers(String username, String email, String password, String lasName, String firstName, boolean enabled,
			String registrationNumber, Users user) {
		super(username, email, password, lasName, firstName, enabled);
		this.registrationNumber = registrationNumber;
		this.user = user;
	}

	// ===== Getters & Setters =====//

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
