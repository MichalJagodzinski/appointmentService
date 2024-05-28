package com.example.AppointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private int id;
    private String description;
    private LocalDateTime appointmentTime;
    private User user;
}
