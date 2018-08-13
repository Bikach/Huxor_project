package fr.huxor.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fr.huxor.dao.IMessagesRepository;
import fr.huxor.dao.INewslettersRepository;
import fr.huxor.entities.Messages;
import fr.huxor.entities.Newsletters;

@Service
public class ContactServiceImpl implements IContactService {
	
	@Autowired
	IMessagesRepository messageRepo;
	@Autowired
	INewslettersRepository newRepo;
	
	/**
	 * Add a new message
	 */
	@Override
	public void addMessage(String email, String firstName, String lastName, String post, Date postDate, boolean process) {
		messageRepo.save(new Messages(lastName, firstName, email, post, postDate, process));
	}

	@Override
	public void addNewslettter(String email) {
		newRepo.save(new Newsletters(email));
	}

	@Override
	public void deleteMessage(long id) {
		messageRepo.deleteById(id);
	}

	@Override
	public Page<Messages> viewMessage(Date startDate, Date endDate, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
