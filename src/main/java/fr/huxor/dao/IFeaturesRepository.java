package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Features;

public interface IFeaturesRepository extends JpaRepository<Features, Long> {

}
