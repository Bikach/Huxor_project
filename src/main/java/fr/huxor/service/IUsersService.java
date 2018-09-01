package fr.huxor.service;

import java.util.Date;
import java.util.Set;

import fr.huxor.entities.Addresses;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Role;
import fr.huxor.entities.Users;

public interface IUsersService {

	// ===== Customer/Manager =====//
	public void addCustomer(String username, String email, String passwordEncoder, String lastName, String firstName,
			boolean enabled, Date birthDate, String drivingLicenceNumber, Addresses address, Set<Role> roles);

	public void updateCustomer(String username);

	public void deleteCustomer(String username);

	// ===== Admin =====//
	public void addManager(String username, String email, String password, String lastName, String firstName,
			boolean enabled, String registrationNumber, Set<Role> roles);

	public void updateManager(String username);

	public void DeleteManager(String username);

	// ===== Manager/Admin =====//
	public Users findAUser(String username) throws CustomException;

}
