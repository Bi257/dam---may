package com.distribute.booking.repository;

import com.distribute.booking.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntry, Long> {
    // Các phương thức truy vấn tùy chỉnh nếu có
}