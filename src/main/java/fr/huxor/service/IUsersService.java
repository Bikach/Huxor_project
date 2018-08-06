package fr.huxor.service;

import fr.huxor.entities.CustomException;
import fr.huxor.entities.Users;

public interface IUsersService {
	
	public Users findAUser(long id) throws CustomException;

}
