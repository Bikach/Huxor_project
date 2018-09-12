package fr.huxor.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Messages;

public interface IContactService {

	// Manager
	public void addMessage(String email, String firstName, String lastName, String post, LocalDate postDate, boolean proces);

	public void addNewslettter(String email);

	public void deleteMessage(long id);
	
	public void topicResolut(long id, boolean process);
	
	public Page<Messages>  viewMessage(LocalDate startDate, LocalDate endDate, boolean process, int page, int size);
}
