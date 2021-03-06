package fr.huxor.service;

import org.springframework.data.domain.Page;

import fr.huxor.entities.CustomException;
import fr.huxor.entities.LeaseAgreements;

public interface ILeaseService {
	
	//USER
	public void deleteLease(long id);
	
	public Page<LeaseAgreements>  leaseAgreementFromUser(String user, int page, int size);

	
	//Manager/Admin
	public LeaseAgreements findALease(String numberAgreement) throws CustomException;

	public void totalPriceReturnCar(String numberAgreement, int comebackKm) throws CustomException;

	public void addNumberAgreement(long id, String numberAgreement);
	
	
	public Page<LeaseAgreements> leaseAgreementNullPage(String nullOrNotNull,  String customer, int page, int size);
	

}
