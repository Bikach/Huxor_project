package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Brands;

public interface IBrandsRepository extends JpaRepository<Brands, String> {

}
