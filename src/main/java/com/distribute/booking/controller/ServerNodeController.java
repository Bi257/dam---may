package com.distribute.booking.controller;

import com.distribute.booking.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServerNodeController {
    @Autowired
    private LogRepository logRepo;
    @Value("${server.id}")
    private String serverId;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("serverId", serverId);
        model.addAttribute("logs", logRepo.findAll(Sort.by(Sort.Direction.DESC, "timestamp")));
        return "dashboard";
    }
}