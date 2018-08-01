package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Newsletters;

public interface INewslettersRepository extends JpaRepository<Newsletters, Long>{

}
