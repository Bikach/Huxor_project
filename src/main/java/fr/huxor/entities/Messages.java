package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Messages implements Serializable {

	private static final long serialVersionUID = 4268401372739917861L;

	@Id
	@GeneratedValue
	private long idMessage;
	private String lastName;
	private String firstName;
	@Email
	private String email;
	private String post;

	/**
	 * Default constructor
	 */
	public Messages() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param post
	 */
	public Messages(String lastName, String firstName, @Email String email, String post) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.post = post;
	}

	// ===== Getters & Setters =====//

	public long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(long idMessage) {
		this.idMessage = idMessage;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}
