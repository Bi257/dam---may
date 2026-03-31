package com.distribute.booking.controller;

import com.distribute.booking.model.*;
import com.distribute.booking.repository.*;
import com.distribute.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private TicketRepository ticketRepo;
    @Autowired
    private LogRepository logRepo;
    @Autowired
    private LamportClockService clockService;
    @Autowired
    private NetworkService networkService;

    @Value("${server.id}")
    private String serverId;

    @PostMapping("/book")
    public String bookTicket(@RequestBody FlightTicket ticket) {
        long time = clockService.tick();
        ticket.setLamportTime(time);
        ticket.setProcessedBy(serverId);
        ticketRepo.save(ticket);

        saveLog("Đặt vé mới: " + ticket.getCustomerName(), time, "PRIVATE");
        networkService.broadcastSync(ticket);
        return "Thành công tại t=" + time;
    }

    @PostMapping("/sync")
    public void receiveSync(@RequestBody FlightTicket ticket) {
        clockService.update(ticket.getLamportTime());
        ticketRepo.save(ticket);
        saveLog("Đồng bộ vé từ " + ticket.getProcessedBy(), clockService.getTime(), "SYNC");
    }

    private void saveLog(String msg, long time, String type) {
        LogEntry log = new LogEntry();
        log.setMessage(msg);
        log.setLamportTime(time);
        log.setType(type);
        log.setServerId(serverId);
        logRepo.save(log);
    }
}