package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Models;

public interface IModelsRepository extends JpaRepository<Models, String> {

}
