package fr.huxor.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.huxor.dao.IUsersRepository;
import fr.huxor.entities.Addresses;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Customers;
import fr.huxor.entities.Managers;
import fr.huxor.entities.Users;

public class UsersServiceImpl implements IUsersService {

	@Autowired
	private IUsersRepository usersRepo;

	// ===== Customer/Manager =====//

	@Override
	public void addCustomer(String email, String password, String lastName, String firstName, boolean enabled,
			Date birthDate, String drivingLicenceNumber, Addresses address) {
		usersRepo.save(new Customers(email, password, lastName, firstName, enabled, birthDate, drivingLicenceNumber, address));
	}
	

	@Override
	public void updateCustomer(long idCustomer) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteCustomer(long idCustomer) {
		usersRepo.deleteById(idCustomer);
	}

	// ===== Admin =====//

	@Override
	public void addManager(String email, String password, String lastName, String firstName, boolean enabled,
			String registrationNumber) {
		usersRepo.save(new Managers(email, password, lastName, firstName, enabled, registrationNumber));
	}

	@Override
	public void updateManager(long idManager) {
		// TODO
	}
	
	@Override
	public void DeleteManager(long idManager) {
		usersRepo.deleteById(idManager);		
	}

	// ===== Manager/Admin =====//

	@Override
	public Users findAUser(long idUser) throws CustomException {
		Optional<Users> user = usersRepo.findById(idUser);
		if (user == null)
			throw new CustomException("Cette utilisateur n'existe pas");
		// TODO a finir
		Users u = user.get();
		return u;
	}



}
