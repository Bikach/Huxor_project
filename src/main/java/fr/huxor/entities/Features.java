package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Features implements Serializable {

	private static final long serialVersionUID = 6301692554367921705L;

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private long idFeature;
	private byte carDoor;
	private byte seatingCapacity;
	private byte power;
	private String color;
	private String transmission;
	private String fuel;
	private String typeCar;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CODE_MODEL")
	private Models model;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CODE_BRAND")	
	private Brands brand;

	/**
	 * Default constructor
	 */
	public Features() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param carDoor
	 * @param seatingCapacity
	 * @param power
	 * @param color
	 * @param transmission
	 * @param fuel
	 * @param typeCar
	 * @param model
	 * @param brand
	 */
	public Features(byte carDoor, byte seatingCapacity, byte power, String color, String transmission, String fuel,
			String typeCar, Models model, Brands brand) {
		this.carDoor = carDoor;
		this.seatingCapacity = seatingCapacity;
		this.power = power;
		this.color = color;
		this.transmission = transmission;
		this.fuel = fuel;
		this.typeCar = typeCar;
		this.model = model;
		this.brand = brand;
	}

	// ===== Getters & Setters =====//

	public long getIdFeature() {
		return idFeature;
	}

	public void setIdFeature(long idFeature) {
		this.idFeature = idFeature;
	}

	public byte getCarDoor() {
		return carDoor;
	}

	public void setCartDoor(byte carDoor) {
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

	public String getTypeCar() {
		return typeCar;
	}

	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}

	public Models getModel() {
		return model;
	}

	public void setModel(Models model) {
		this.model = model;
	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

}
