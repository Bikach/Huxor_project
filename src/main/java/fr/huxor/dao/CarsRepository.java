package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long>{

}
