package com.distribute.booking.repository;

import com.distribute.booking.model.Log; // Đảm bảo đúng package của class Log
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    // JpaRepository đã có sẵn các hàm save, findAll, delete...
    // Dương không cần viết thêm gì ở đây trừ khi muốn tạo query riêng.
}