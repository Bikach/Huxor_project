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

import org.springframework.context.annotation.Primary;

@Entity
public class Features implements Serializable {

	private static final long serialVersionUID = 6301692554367921705L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFeature;
	private byte carDoor;
	private byte seatingCapacity;
	private byte power;
	private String color;
	private String transmission;
	private String fuel;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_NAME")
	private Brands brand;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "MODEL_NAME")
	private Models model;

	/**
	 * Default constructor
	 */
	public Features() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param brand
	 * @param carDoor
	 * @param seatingCapacity
	 * @param power
	 * @param color
	 * @param transmission
	 * @param fuel
	 */
	public Features(byte carDoor, byte seatingCapacity, byte power, String color, String transmission, String fuel, Brands brand, Models model) {
		this.carDoor = carDoor;
		this.seatingCapacity = seatingCapacity;
		this.power = power;
		this.color = color;
		this.transmission = transmission;
		this.fuel = fuel;
		this.brand = brand;
		this.model = model;
	}

	// ===== Getters & Setters =====//

	public long getIdFeature() {
		return idFeature;
	}

	public void setIdFeature(long idFeature) {
		this.idFeature = idFeature;
	}

	public void setCarDoor(byte carDoor) {
		this.carDoor = carDoor;
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
