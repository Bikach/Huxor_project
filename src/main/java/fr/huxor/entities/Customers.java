package fr.huxor.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@DiscriminatorValue("CU")
public class Customers extends Users {

	private static final long serialVersionUID = -3900769779146477645L;

	@Past
	@NotNull
	private Date birthDate;
	@NotNull
	private String drivingLicenceNumber;
	@OneToOne
	@JoinColumn(name = "CODE_USER")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "CODE_ADRESS")
	private Addresses address;

	/**
	 * Default constructor
	 */
	public Customers() {
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
	 * @param birthDate
	 * @param drivingLicenceNumber
	 * @param user
	 * @param address
	 */
	public Customers(String username, String email, String password, String lasName, String firstName, boolean enabled,
			Date birthDate, String drivingLicenceNumber, Users user, Addresses address) {
		super(username, email, password, lasName, firstName, enabled);
		this.birthDate = birthDate;
		this.drivingLicenceNumber = drivingLicenceNumber;
		this.user = user;
		this.address = address;
	}

	// ===== Getters & Setters =====//

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}

	public void setDrivingLicenceNumber(String drivingLicenceNumber) {
		this.drivingLicenceNumber = drivingLicenceNumber;
	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Addresses getAddress() {
		return address;
	}
	
	public void setAddress(Addresses address) {
		this.address = address;
	}
}
