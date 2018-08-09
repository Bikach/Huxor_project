package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import fr.huxor.util.CarsCategorys;

@Entity
public class Cars implements Serializable {

	private static final long serialVersionUID = 3654714278688930949L;

	@Id
	@NotNull
	private String licencePlate;
	private int kmNumber;
	private double dailyPrice;
	private float kmPrice;

	@Enumerated(EnumType.STRING)
	private CarsCategorys carCategory;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_FEATURE")
	private Features feature;

	/**
	 * Default constructor
	 */
	public Cars() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param licencePlate
	 * @param kmNumber
	 * @param category
	 * @param dailyPrice
	 * @param kmPrice
	 */
	public Cars(String licencePlate, int kmNumber, CarsCategorys category, double dailyPrice, float kmPrice) {
		this.licencePlate = licencePlate;
		this.kmNumber = kmNumber;
		this.carCategory = category;
		this.dailyPrice = dailyPrice;
		this.kmPrice = kmPrice;
	}

	// ===== Getters & Setters =====//

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

	public CarsCategorys getCarCategory() {
		return carCategory;
	}

	public void setCarCategory(CarsCategorys carCategory) {
		this.carCategory = carCategory;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public float getKmPrice() {
		return kmPrice;
	}

	public void setKmPrice(byte kmPrice) {
		this.kmPrice = kmPrice;
	}
		

}
