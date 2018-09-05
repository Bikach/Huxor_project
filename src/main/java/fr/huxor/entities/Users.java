package fr.huxor.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE_USER", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Users implements Serializable {

	private static final long serialVersionUID = -9125319231283171487L;

	@Id
	private String username;
	@Email
	@NotNull 
	private String email;  
	@NotNull
	private String password;
	private String firstName;
	private String lastName;
	@NotNull
	private boolean enabled;
	@OneToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	/**
	 * Default constructor
	 */
	public Users() { 
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param lasName
	 * @param firstName
	 * @param enabled
	 * 
	 */
	public Users(String username, String email, String password, String lasName, String firstName, boolean enabled, Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.lastName = lasName;
		this.firstName = firstName;
		this.enabled = enabled;
		this.roles = roles;
	}

	// ===== Getters & Setters =====//

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
