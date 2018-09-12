package fr.huxor.dao;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.huxor.entities.Messages;

public interface IMessagesRepository extends JpaRepository<Messages, Long> {

	/**
	 * Displays messages within two dates that are processed or not
	 * 
	 * @param pickupDate
	 * @param dropDate
	 * @param process
	 * @param pageable
	 * @return message page
	 */
	@Query("SELECT m FROM Messages m WHERE m.postDate BETWEEN :pickupDate AND :dropDate AND process = :process")
	public Page<Messages> viewMessages(@Param("pickupDate") LocalDate pickupDate, @Param("dropDate") LocalDate dropDate,
			@Param("process") boolean process, Pageable pageable);

}
