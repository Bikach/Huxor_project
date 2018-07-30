package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Features implements Serializable {

	private static final long serialVersionUID = 6301692554367921705L;

	@Id
	@GeneratedValue
	private long idFeature;
	private byte cartDoor;
	private byte seatingCapacity;
	private byte power;
	private String color;
	private String transmission;
	private String fuel;
	private String typeChar;

	@ManyToOne
	@JoinColumn(name = "CODE_MODEL")
	private Models model;
	@ManyToOne
	@JoinColumn(name = "CODE_BRAND")	
	private Brands brand;

	/**
	 * Default constructor
	 */
	public Features() {}

	/**
	 * Constructor with parameters
	 * 
	 * @param cartDoor
	 * @param seatingCapacity
	 * @param power
	 * @param color
	 * @param transmission
	 * @param fuel
	 * @param typeChar
	 * @param model
	 * @param brand
	 */
	public Features(byte cartDoor, byte seatingCapacity, byte power, String color, String transmission, String fuel,
			String typeChar, Models model, Brands brand) {
		this.cartDoor = cartDoor;
		this.seatingCapacity = seatingCapacity;
		this.power = power;
		this.color = color;
		this.transmission = transmission;
		this.fuel = fuel;
		this.typeChar = typeChar;
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

	public byte getCartDoor() {
		return cartDoor;
	}

	public void setCartDoor(byte cartDoor) {
		this.cartDoor = cartDoor;
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

	public String getTypeChar() {
		return typeChar;
	}

	public void setTypeChar(String typeChar) {
		this.typeChar = typeChar;
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
