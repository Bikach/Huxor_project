package fr.huxor.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
public class LeaseAgreements implements Serializable {

	private static final long serialVersionUID = 7647304234628938461L;

	@Id
	@NotNull
	private String numberAgreement;
	@NotNull
	@FutureOrPresent
	private Date startDate;
	@Future
	@NotNull
	private Date comebackDate;
	@NotNull
	private boolean dropCar;
	@NotNull
	private double price;

	@ManyToOne
	@JoinColumn(name = "CODE_CUSTOMER")
	private Customers customer;
	@ManyToOne
	@JoinColumn(name = "CODE_CAR")
	private Cars car;
	@OneToOne(mappedBy="leaseAgreement")
	private CheckCars checkCar;

	/**
	 * Default constructor
	 */
	public LeaseAgreements() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param numberAgreement
	 * @param startDate
	 * @param comebackDate
	 * @param dropCar
	 * @param customer
	 * @param car
	 * @param price
	 */
	public LeaseAgreements(String numberAgreement, Date startDate, Date comebackDate, boolean dropCar,
			Customers customer, Cars car, double price) {
		this.numberAgreement = numberAgreement;
		this.startDate = startDate;
		this.comebackDate = comebackDate;
		this.dropCar = dropCar;
		this.customer = customer;
		this.car = car;
		this.price = price;
	}

	// ===== Getters & Setters =====//

	public String getNumberAgreement() {
		return numberAgreement;
	}

	public void setNumberAgreement(String numberAgreement) {
		this.numberAgreement = numberAgreement;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getComebackDate() {
		return comebackDate;
	}

	public void setComebackDate(Date comebackDate) {
		this.comebackDate = comebackDate;
	}

	public boolean isDropCar() {
		return dropCar;
	}

	public void setDropCar(boolean dropCar) {
		this.dropCar = dropCar;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	public CheckCars getCheckCar() {
		return checkCar;
	}

	public void setCheckCar(CheckCars checkCar) {
		this.checkCar = checkCar;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
