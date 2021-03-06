package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cars implements Serializable {

	private static final long serialVersionUID = 3654714278688930949L;

	@Id
	@NotNull
	private String licencePlate;
	private String picturePath;
	private int kmNumber;
	private double dailyPrice;
	private float kmPrice;
	private byte carDoor;
	private byte seatingCapacity;
	private byte power;
	private String color;
	private String transmission;
	private String fuel;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_NAME")
	private Categorys category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_NAME")
	private Brands brand;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "MODEL_NAME")
	private Models model;

	/**
	 * Default constructor
	 */
	public Cars() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param licencePlate
	 * @param picturePath
	 * @param kmNumber
	 * @param dailyPrice
	 * @param kmPrice
	 * @param carDoor
	 * @param seatingCapacity
	 * @param power
	 * @param color
	 * @param transmission
	 * @param fuel
	 */
	public Cars(String licencePlate, String picturePath, int kmNumber, double dailyPrice, float kmPrice, byte carDoor, byte seatingCapacity,
			byte power, String color, String transmission, String fuel) {
		this.picturePath = picturePath;
		this.licencePlate = licencePlate;
		this.kmNumber = kmNumber;
		this.dailyPrice = dailyPrice;
		this.kmPrice = kmPrice; 
		this.carDoor = carDoor;
		this.seatingCapacity = seatingCapacity;
		this.power = power;
		this.color = color;
		this.transmission = transmission;
		this.fuel = fuel;
	}

	// ===== Getters & Setters =====//

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public int getKmNumber() {
		return kmNumber;
	}

	public void setKmNumber(int kmNumber) {
		this.kmNumber = kmNumber;
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

	public void setKmPrice(float kmPrice) {
		this.kmPrice = kmPrice;
	}

	public byte getCarDoor() {
		return carDoor;
	}

	public void setCarDoor(byte carDoor) {
		this.carDoor = carDoor;
	}

	public byte getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(byte seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public byte getPower() {
		return power;
	}

	public void setPower(byte power) {
		this.power = power;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Categorys getCategory() {
		return category;
	}

	public void setCategory(Categorys category) {
		this.category = category;
	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

	public Models getModel() {
		return model;
	}

	public void setModel(Models model) {
		this.model = model;
	}

}
