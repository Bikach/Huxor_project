package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Authorities implements Serializable {

	private static final long serialVersionUID = 270521277043469869L;

	@Id
	@NotNull
	private String authority;
	@ManyToOne
	@JoinColumn(name = "CODE_USER")
	private Users user;

	/**
	 * Default constructor
	 */
	public Authorities() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param authority
	 * @param user
	 */
	public Authorities(@NotNull String authority, Users user) {
		this.authority = authority;
		this.user = user;
	}

	// ===== Getters & Setters =====//

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
