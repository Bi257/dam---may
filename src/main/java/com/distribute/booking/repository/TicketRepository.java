package com.distribute.booking.repository;

import com.distribute.booking.model.Ticket; // Đảm bảo đúng package của class Ticket
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Tương tự, dùng JpaRepository thay cho MongoRepository
}