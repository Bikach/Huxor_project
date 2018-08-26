package fr.huxor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.huxor.dao.IUsersRepository;
import fr.huxor.entities.CustomUserDetails;
import fr.huxor.entities.Users;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private IUsersRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = userRepo.findById(username);

		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();

	}

}
