package com.distribute.booking.repository;

import com.distribute.booking.model.FlightTicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<FlightTicket, Long> {
}