package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cars implements Serializable {

	private static final long serialVersionUID = 3654714278688930949L;

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private long idCar;
	@NotNull
	private String licencePlate;
	private int kmNumber;
	private double dailyPrice;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
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
	public Cars(String licencePlate, int kmNumber, double dailyPrice,  Features feature) {
		this.licencePlate = licencePlate;
		this.kmNumber = kmNumber;
		this.dailyPrice = dailyPrice;
		this.feature = feature;
	}

	// ===== Getters & Setters =====//

	public long getIdCar() {
		return idCar;
	}

	public void setIdCar(long idCar) {
		this.idCar = idCar;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public int getKmNumber() {
		return kmNumber;
	}

	public void setKmNumber(int kmNumber) {
		this.kmNumber = kmNumber;
	}

	public Features getFeature() {
		return feature;
	}

	public void setFeature(Features feature) {
		this.feature = feature;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

}
