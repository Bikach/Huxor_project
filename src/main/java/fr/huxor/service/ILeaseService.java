package fr.huxor.service;

import org.springframework.data.domain.Page;

import fr.huxor.entities.CustomException;
import fr.huxor.entities.LeaseAgreements;

public interface ILeaseService {
	
	//Manager/Admin
	public LeaseAgreements findALease(String numberAgreement) throws CustomException;

	public void totalPriceReturnCar(String numberAgreement, int comebackKm) throws CustomException;

	public void addNumberAgreement(long id, String numberAgreement);
	
	public Page<LeaseAgreements> leaseAgreementPage(String status,  String customer, int page, int size);

}
