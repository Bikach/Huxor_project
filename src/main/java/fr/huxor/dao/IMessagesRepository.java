package fr.huxor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.huxor.entities.Messages;

public interface IMessagesRepository extends JpaRepository<Messages, Long>{

}
