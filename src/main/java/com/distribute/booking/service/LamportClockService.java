package com.distribute.booking.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LamportClockService {
    private AtomicLong clock = new AtomicLong(0);

    public long tick() {
        return clock.incrementAndGet();
    }

    public void update(long receivedTime) {
        clock.set(Math.max(clock.get(), receivedTime) + 1);
    }

    public long getTime() {
        return clock.get();
    }
}