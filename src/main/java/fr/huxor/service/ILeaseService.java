package fr.huxor.service;

import fr.huxor.entities.CustomException;
import fr.huxor.entities.LeaseAgreements;

public interface ILeaseService {
	
	public LeaseAgreements findALease(String numberAgreement) throws CustomException;

	public void totalPriceReturnCar(String numberAgreement, int comebackKm) throws CustomException;

	public void addNumberAgreement(long id, String numberAgreement);

}
