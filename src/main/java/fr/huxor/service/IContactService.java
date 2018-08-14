package fr.huxor.service;

import java.util.Date;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Messages;

public interface IContactService {

	// Manager
	public void addMessage(String email, String firstName, String lastName, String post, Date postDate, boolean proces);

	public void addNewslettter(String email);

	public void deleteMessage(long id);
	
	public void topicResolut(long id, boolean process);
	
	public Page<Messages>  viewMessage(Date startDate,Date endDate, boolean process, int page, int size);
}
