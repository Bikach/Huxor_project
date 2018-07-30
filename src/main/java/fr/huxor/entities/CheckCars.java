package fr.huxor.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CheckCars implements Serializable {

	private static final long serialVersionUID = -1882478765448279208L;

	@Id
	private String checkNumber;
	private String carriageBefore;
	private String carriageAftter;
	private String opticsBefore;
	private String opticsAfter;
	private String panesBefore;
	private String panesAfter;
	private String enginesBefore;
	private String engineAfter;

	@ManyToOne
	@JoinColumn(name = "CODE_CAR")
	private Cars car;
	@ManyToOne
	@JoinColumn(name = "CODE_MANAGER")
	private Managers manager;
	@OneToOne(mappedBy = "checkCar")
	private LeaseAgreements leaseAgreement;

	/**
	 * Default constructor
	 */
	public CheckCars() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param chekNumber
	 * @param carriageBefore
	 * @param carriageAftter
	 * @param opticsBefore
	 * @param opticsAfter
	 * @param panesBefore
	 * @param panesAfter
	 * @param enginesBefore
	 * @param engineAfter
	 * @param car
	 * @param manager
	 * @param leaseAgreement
	 */
	public CheckCars(String checkNumber, String carriageBefore, String carriageAftter, String opticsBefore,
			String opticsAfter, String panesBefore, String panesAfter, String enginesBefore, String engineAfter,
			Cars car, Managers manager, LeaseAgreements leaseAgreement) {
		this.checkNumber = checkNumber;
		this.carriageBefore = carriageBefore;
		this.carriageAftter = carriageAftter;
		this.opticsBefore = opticsBefore;
		this.opticsAfter = opticsAfter;
		this.panesBefore = panesBefore;
		this.panesAfter = panesAfter;
		this.enginesBefore = enginesBefore;
		this.engineAfter = engineAfter;
		this.car = car;
		this.manager = manager;
		this.leaseAgreement = leaseAgreement;
	}

	// ===== Getters & Setters =====//

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getCarriageBefore() {
		return carriageBefore;
	}

	public void setCarriageBefore(String carriageBefore) {
		this.carriageBefore = carriageBefore;
	}

	public String getCarriageAftter() {
		return carriageAftter;
	}

	public void setCarriageAftter(String carriageAftter) {
		this.carriageAftter = carriageAftter;
	}

	public String getOpticsBefore() {
		return opticsBefore;
	}

	public void setOpticsBefore(String opticsBefore) {
		this.opticsBefore = opticsBefore;
	}

	public String getOpticsAfter() {
		return opticsAfter;
	}

	public void setOpticsAfter(String opticsAfter) {
		this.opticsAfter = opticsAfter;
	}

	public String getPanesBefore() {
		return panesBefore;
	}

	public void setPanesBefore(String panesBefore) {
		this.panesBefore = panesBefore;
	}

	public String getPanesAfter() {
		return panesAfter;
	}

	public void setPanesAfter(String panesAfter) {
		this.panesAfter = panesAfter;
	}

	public String getEnginesBefore() {
		return enginesBefore;
	}

	public void setEnginesBefore(String enginesBefore) {
		this.enginesBefore = enginesBefore;
	}

	public String getEngineAfter() {
		return engineAfter;
	}

	public void setEngineAfter(String engineAfter) {
		this.engineAfter = engineAfter;
	}

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	public Managers getManager() {
		return manager;
	}

	public void setManager(Managers manager) {
		this.manager = manager;
	}

	public LeaseAgreements getLeaseAgreement() {
		return leaseAgreement;
	}

	public void setLeaseAgreement(LeaseAgreements leaseAgreement) {
		this.leaseAgreement = leaseAgreement;
	}

}
