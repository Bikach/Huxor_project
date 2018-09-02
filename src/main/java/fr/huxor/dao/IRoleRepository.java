package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.Role;


public interface IRoleRepository extends JpaRepository<Role, Integer>{
	
	@Query(" SELECT r FROM Role  r where role = :name")
	public Role findByName(@Param("name")  String name);

}
