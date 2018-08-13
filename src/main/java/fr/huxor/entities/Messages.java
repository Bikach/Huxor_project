package fr.huxor.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Messages implements Serializable {

	private static final long serialVersionUID = 4268401372739917861L;

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private long idMessage;
	private String lastName;
	private String firstName;
	@Email
	private String email;
	private String post;
	private Date postDate;
	private boolean process;

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
	public Messages(String lastName, String firstName,  String email, String post, Date postDate, boolean process) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.post = post;
		this.postDate = postDate;
		this.process = process;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public boolean isProcess() {
		return process;
	}

	public void setProcess(boolean process) {
		this.process = process;
	}

}
