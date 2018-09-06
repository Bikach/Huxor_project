package fr.huxor.service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.huxor.dao.IUsersRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Managers;
import fr.huxor.entities.Role;
import fr.huxor.entities.Users;
  
@Service
@Transactional
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private IUsersRepository usersRepo;

	// ===== Customer/Manager =====//
	
	@Override
	public void addCustomer(String username, String email, String passwordEncoder, String lastName, String firstName,
			boolean enabled, Date birthDate, String drivingLicenceNumber, Addresses address, Set<Role> roles) {
		usersRepo.save(new Customers(username, email, passwordEncoder, lastName, firstName, enabled, birthDate, drivingLicenceNumber, address, roles));
		
	}

	@Override
	public void updateCustomer(String idCustomer) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void deleteCustomer(String username) {
		usersRepo.deleteById(username);
	}

	// ===== Admin =====//
	
	@Override
	public void addManager(String username, String email, String password, String lastName, String firstName, boolean enabled,
			String registrationNumber, Set<Role> roles) {
		usersRepo.save(new Managers(username, email, password, lastName, firstName, enabled, registrationNumber, roles));
	}

	@Override
	public void updateManager(String idManager) {
		// TODO
	}
	
	@Override
	public void DeleteManager(String username) {
		usersRepo.deleteById(username);		
	}

	// ===== Manager/Admin =====//
	
	@Override
	public Users findAUser(String username) throws CustomException {
		Optional<Users> user = usersRepo.findById(username);
		if (user == null)
			throw new CustomException("Cette utilisateur n'existe pas");
		// TODO a finir
		Users u = user.get();
		return u;
	}

}
