package com.distribute.booking.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "logs")
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private long lamportTime;
    private String type;
    private String serverId;
    private LocalDateTime timestamp = LocalDateTime.now();
}