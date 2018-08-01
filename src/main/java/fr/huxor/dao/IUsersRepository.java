package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Users;


public interface IUsersRepository extends JpaRepository<Users, Long>{

}
