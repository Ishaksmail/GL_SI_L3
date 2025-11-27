package TP3.EX2.base;

import java.time.LocalDateTime;

public class Appointment {
    protected Patient patient;
    protected Doctor doctor;
    protected LocalDateTime dateTime;
    protected AppointmentStatus status;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime dateTime, AppointmentStatus status) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.status = status;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "-> : Appointment : " + doctor + " | " + patient + " | " + dateTime + " | " + status;
    }
}
