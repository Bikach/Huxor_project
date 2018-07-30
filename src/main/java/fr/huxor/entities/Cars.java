package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cars implements Serializable {

	private static final long serialVersionUID = 3654714278688930949L;

	@Id
	@GeneratedValue
	private long idCar;
	@NotNull
	private byte licencePlate;
	private String kmNumber;
	@ManyToOne
	@JoinColumn(name = "CODE_FEATURE")
	private Features feature;

	/**
	 * Default constructor
	 */
	public Cars() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param licencePlate
	 * @param kmNumber
	 * @param feature
	 */
	public Cars(byte licencePlate, String kmNumber, Features feature) {
		this.licencePlate = licencePlate;
		this.kmNumber = kmNumber;
		this.feature = feature;
	}

	// ===== Getters & Setters =====//

	public long getIdCar() {
		return idCar;
	}

	public void setIdCar(long idCar) {
		this.idCar = idCar;
	}

	public byte getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(byte licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getKmNumber() {
		return kmNumber;
	}

	public void setKmNumber(String kmNumber) {
		this.kmNumber = kmNumber;
	}

	public Features getFeature() {
		return feature;
	}

	public void setFeature(Features feature) {
		this.feature = feature;
	}

}
