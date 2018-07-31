package fr.huxor.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@PrimaryKeyJoinColumn(name="CODE_USER")
public class Customers extends Users {

	private static final long serialVersionUID = -3900769779146477645L;

	@Past
	@NotNull
	private Date birthDate;
	@NotNull
	private String drivingLicenceNumber;
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
	 * @param email (Users)
	 * @param password (Users)
	 * @param lasName (Users)
	 * @param firstName (Users)
	 * @param enabled (Users)
	 * @param birthDate
	 * @param drivingLicenceNumber
	 * @param address
	 */
	public Customers( String email, String password, String lasName, String firstName, boolean enabled,
			Date birthDate, String drivingLicenceNumber, Addresses address) {
		super( email, password, lasName, firstName, enabled);
		this.birthDate = birthDate;
		this.drivingLicenceNumber = drivingLicenceNumber;
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

	public Addresses getAddress() {
		return address;
	}
	
	public void setAddress(Addresses address) {
		this.address = address;
	}
}
