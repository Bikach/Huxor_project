package fr.huxor.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@PrimaryKeyJoinColumn(name="CODE_USER")
@DiscriminatorValue("CU")
public class Customers extends Users {

	private static final long serialVersionUID = -3900769779146477645L;

	@Past
	@NotNull
	private LocalDate birthDate;
	@NotNull
	private String drivingLicenceNumber;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CODE_ADRESS")
	private Addresses address;

	/**O
	 * Default constructor
	 */
	public Customers() { 
		super(); 
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param username
	 * @param email (Users)
	 * @param password (Users)
	 * @param lasName (Users)
	 * @param firstName (Users)
	 * @param enabled (Users)
	 * @param birthDate
	 * @param drivingLicenceNumber
	 * @param address
	 */
	public Customers(String username,  String email, String password, String lasName, String firstName, boolean enabled,
			LocalDate birthDate, String drivingLicenceNumber, Addresses address, Set<Role>roles) {
		super(username, email, password, lasName, firstName, enabled, roles);
		this.birthDate = birthDate;
		this.drivingLicenceNumber = drivingLicenceNumber;
		this.address = address;
	}
 
	// ===== Getters & Setters =====//

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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
