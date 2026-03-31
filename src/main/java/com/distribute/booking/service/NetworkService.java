package com.distribute.booking.service;

import com.distribute.booking.model.FlightTicket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NetworkService {
    @Value("${peer.servers}")
    private String peers;

    private final RestTemplate restTemplate = new RestTemplate();

    @Async
    public void broadcastSync(FlightTicket ticket) {
        if (peers == null || peers.isEmpty())
            return;
        String[] peerList = peers.split(",");
        for (String peer : peerList) {
            try {
                restTemplate.postForObject(peer.trim() + "/api/sync", ticket, String.class);
            } catch (Exception e) {
                System.err.println("Không thể kết nối tới node: " + peer);
            }
        }
    }
}