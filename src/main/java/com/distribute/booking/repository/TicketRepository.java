package com.distribute.booking.repository;

import com.distribute.booking.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<FlightTicket, Long> {
    // Các phương thức truy vấn tùy chỉnh nếu có
}