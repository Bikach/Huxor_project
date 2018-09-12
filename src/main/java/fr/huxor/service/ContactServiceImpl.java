package fr.huxor.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	 * 
	 * @param email
	 * @param fistname
	 * @param lastname
	 * @param post
	 * @param postdate
	 * @param process
	 */
	@Override
	public void addMessage(String email, String firstName, String lastName, String post, LocalDate postDate,
			boolean process) {
		messageRepo.save(new Messages(lastName, firstName, email, post, postDate, process));
	}

	/**
	 * Add a email to newsletter
	 * 
	 * @param email
	 */ 
	@Override
	public void addNewslettter(String email) {
		newRepo.save(new Newsletters(email));
	}

	/**
	 * delete a message to bdd
	 * 
	 * @param id message
	 */
	@Override
	public void deleteMessage(long id) {
		messageRepo.deleteById(id);
	}

	/**
	 * Pass the message in resolution
	 * 
	 * @param id
	 * @param process
	 */
	@Override
	public void topicResolut(long id, boolean process) {
		Messages message = findMessage(id);
		message.setProcess(process);
		messageRepo.save(message);
	}

	/**
	 * displays messages posted between two dates
	 * 
	 * @param startsate
	 * @param enddate
	 * @param page
	 * @param size
	 */
	@Override
	public Page<Messages> viewMessage(LocalDate startDate, LocalDate endDate, boolean process, int page, int size) {
		return messageRepo.viewMessages(startDate, endDate, process, PageRequest.of(page, size));
	}

	// ===== private function =====//

	/**
	 * find a message to bdd
	 * 
	 * @param id
	 * @return a message
	 */
	private Messages findMessage(long id) {
		Optional<Messages> mesOpt = messageRepo.findById(id);
		Messages message = mesOpt.get();
		return message;
	}

}
