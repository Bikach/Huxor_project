package fr.huxor.service;

import java.util.Date;

import fr.huxor.entities.Addresses;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Managers;
import fr.huxor.entities.Users;

public interface IUsersService {

	// ===== Customer/Manager =====//
	public void addCustomer(String email, String password, String lastName, String firstName, boolean enabled,
			Date birthDate, String drivingLicenceNumber, Addresses address);
	public void updateCustomer(long  id);
	public void deleteCustomer(long id);
	// ===== Admin =====//
	public void addManager(String email, String password, String lastName, String firstName, boolean enabled,
			String registrationNumber);
	public void updateManager(long id);
	public void DeleteManager(long id);
	// ===== Manager/Admin =====//
	public Users findAUser(long id) throws CustomException;

}
