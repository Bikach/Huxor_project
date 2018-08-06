package fr.huxor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.huxor.dao.IUsersRepository;
import fr.huxor.entities.CustomException;
import fr.huxor.entities.Users;



public class UsersServiceImpl implements IUsersService {

	@Autowired
	private IUsersRepository usersRepo;
	
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
