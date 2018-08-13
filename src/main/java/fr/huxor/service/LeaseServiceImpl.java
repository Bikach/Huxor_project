package fr.huxor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.LeaseAgreements;

public class LeaseServiceImpl implements ILeaseService {
	
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;
	
	RentalServiceImpl rentalServ;
	
	private static final int DAILY_KM = 150;

	/**
	 * Search lease agreement in database
	 * 
	 * @param numberAgreement
	 */
	@Override
	public LeaseAgreements findALease(String numberAgreement) throws CustomException {
		Optional<LeaseAgreements> lease = leaseRepo.findById(numberAgreement);
		if (lease == null)
			throw new CustomException("Le contrat n° " + numberAgreement + " n'existe pas");
		LeaseAgreements l = lease.get();
		return l;
	}
	
	/**
	 * Update total price with extra km
	 * 
	 * @param totalPrice
	 * @param numberAgreement
	 * @param comebackKm
	 * @throws CustomException
	 */
	@Override
	public void totalPriceReturnCar( String numberAgreement, int comebackKm) throws CustomException {
		LeaseAgreements lease = findALease(numberAgreement);
		lease.setEndKm(comebackKm);
		int days = rentalServ.nbDaysRent(lease.getStartDate().toString(), lease.getComebackDate().toString());
		int maxPermittedKm = days * DAILY_KM;
		int totalKmDrive = lease.getEndKm() - lease.getStartKm();
		int extraKm = maxPermittedKm - totalKmDrive;
		double priceExtraKm =  (extraKm < 0) ? (extraKm * -1)*lease.getCar().getKmPrice() : 0;
		
		lease.setPrice(priceExtraKm);
		leaseRepo.save(lease);
	}

	@Override
	public void addNumberAgreement(long id, String numberAgreement) {
		// TODO Auto-generated method stub
		
	}
	

}
