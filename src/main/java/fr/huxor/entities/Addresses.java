package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Addresses implements Serializable {

	private static final long serialVersionUID = 217921902342387244L;

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private long idAddress;
	@NotNull
	private String street;
	private String city;
	@NotNull
	private String postalCode;

	/**
	 * Default constructor
	 */
	public Addresses() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param street
	 * @param city
	 * @param postalCode
	 */
	public Addresses(String street, String city, String postalCode) {
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	// ===== Getters & Setters =====//

	public long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(long idAddress) {
		this.idAddress = idAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
