package com.taverne.yagni.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Reservation {
    private String groupName;
    private LocalDateTime arrivalTime;
    private int guestCount;
}
