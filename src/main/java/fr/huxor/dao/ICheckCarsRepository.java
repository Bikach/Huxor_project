package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.CheckCars;

public interface ICheckCarsRepository extends JpaRepository<CheckCars, String>{

}
