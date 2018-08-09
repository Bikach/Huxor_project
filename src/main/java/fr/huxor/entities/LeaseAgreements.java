package fr.huxor.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
public class LeaseAgreements implements Serializable {

	private static final long serialVersionUID = 7647304234628938461L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLeaseArgreements;
	private String numberAgreement;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date comebackDate;
	@NotNull
	private int startKm;
	private int endKm;
	@NotNull
	private double price;

	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name = "CODE_CUSTOMER")
	private Customers customer;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CODE_CAR")
	private Cars car;
	@OneToOne(mappedBy="leaseAgreement", fetch=FetchType.LAZY)
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
	public LeaseAgreements(String numberAgreement, Date startDate, Date comebackDate, int startKm, int endKm,
			Customers customer, Cars car, double price) {
		this.numberAgreement = numberAgreement ;
		this.startDate = startDate;
		this.comebackDate = comebackDate;
		this.startKm = startKm;
		this.endKm = endKm;
		this.customer = customer;
		this.car = car;
		this.price = price;
	}

	// ===== Getters & Setters =====//

	
	public long getIdLeaseArgreements() {
		return idLeaseArgreements;
	}
	
	public void setIdLeaseArgreements(long idLeaseArgreements) {
		this.idLeaseArgreements = idLeaseArgreements;
	}
	
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

	public int getStartKm() {
		return startKm;
	}

	public void setStartKm(int startKm) {
		this.startKm = startKm;
	}

	public int getEndKm() {
		return endKm;
	}

	public void setEndKm(int endKm) {
		this.endKm = endKm;
	}

	public void setComebackDate(Date comebackDate) {
		this.comebackDate = comebackDate;
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
