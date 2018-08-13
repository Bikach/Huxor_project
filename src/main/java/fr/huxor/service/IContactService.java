package fr.huxor.service;

import java.util.Date;

import org.springframework.data.domain.Page;

import fr.huxor.entities.Messages;

public interface IContactService {

	// Manager/Admin
	public void addMessage(String email, String firstName, String lastName, String post, Date postDate, boolean proces);

	public void addNewslettter(String email);

	public void deleteMessage(long id);
	
	public Page<Messages>  viewMessage(Date startDate,Date endDate, int page, int size);
}
