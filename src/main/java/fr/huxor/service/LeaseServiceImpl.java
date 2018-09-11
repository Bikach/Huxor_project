package fr.huxor.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.LeaseAgreements;

@Service
public class LeaseServiceImpl implements ILeaseService {

	@Autowired
	private ILeaseAgreementsRepository leaseRepo;
	@Autowired
	private RentalServiceImpl rentalServ;

	private static final int DAILY_KM = 150;

	/**
	 * Delete lease by id
	 * 
	 * @param id LeaseAgreements
	 */
	@Override
	public void deleteLease(long id) {
		leaseRepo.deleteById(id);
	}

	/**
	 * 
	 * @param customer
	 * @param page     and size
	 * @return page of leaseAgreement by username
	 */
	@Override
	public Page<LeaseAgreements> leaseAgreementFromUser(String user, int page, int size) {
		return leaseRepo.leaseAgreementFromUser(user, PageRequest.of(page, size));
	}

	/**
	 * Search lease agreement in database
	 * 
	 * @param numberAgreement
	 */
	@Override
	public LeaseAgreements findALease(String numberAgreement) throws CustomException {
		Optional<LeaseAgreements> lease = leaseRepo.findByNumberAgreement(numberAgreement);
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
	public void totalPriceReturnCar(String numberAgreement, int endKm) throws CustomException {
		LeaseAgreements lease = findALease(numberAgreement);
		lease.setEndKm(endKm);
		rentalServ.updateKmCar(lease.getCar().getLicencePlate(), endKm);
		int days = rentalServ.nbDaysRent(lease.getStartDate().toString(), lease.getEndDate().toString());
		int maxPermittedKm = days * DAILY_KM;
		int totalKmDrive = lease.getEndKm() - lease.getStartKm();
		int extraKm = maxPermittedKm - totalKmDrive;
		double priceExtraKm = (extraKm < 0) ? (extraKm * -1) * lease.getCar().getKmPrice() : 0;

		lease.setPrice(priceExtraKm);
		leaseRepo.save(lease);
	}

	/**
	 * Add a number agreement to a lease agreement
	 * 
	 * @param id
	 * @param number agreement
	 */
	@Override
	public void addNumberAgreement(long id, String numberAgreement) {
		Optional<LeaseAgreements> l = leaseRepo.findById(id);
		LeaseAgreements lease = l.get();
		lease.setNumberAgreement(numberAgreement);
		leaseRepo.save(lease);
	}

	/**
	 * allows you to retrieve rental contracts that have the agreement number field
	 * null or not to a customer
	 * 
	 * @param status   nut or not null
	 * @param username
	 * @param page     and size
	 * @return page of leaseAgreements
	 */
	@Override
	public Page<LeaseAgreements> leaseAgreementNullPage(String nullOrNotNull, String customer, int page, int size) {
		return leaseRepo.leaseAgreementNullPage(nullOrNotNull, customer, PageRequest.of(page, size));
	}

	/**
	 * Check that the date is later than the current date
	 * 
	 * @param Date
	 * @return true or false
	 * @throws ParseException
	 */
	public boolean checkBookingDate(Date date) throws ParseException {
		LocalDate startDate = LocalDate.parse(date.toString());
		return startDate.isAfter(LocalDate.now());
	}

}
