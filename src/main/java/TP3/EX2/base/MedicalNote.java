package TP3.EX2.base;

import java.time.LocalDateTime;

public class MedicalNote {

    protected Doctor docter;
    protected String description;
    protected LocalDateTime timestamp;

    public MedicalNote(Doctor docter, String description, LocalDateTime timestamp) {
        this.docter = docter;
        this.description = description;
        this.timestamp = timestamp;
    }

    public Doctor getDocter() {
        return docter;
    }

    public void setDocter(Doctor docter) {
        this.docter = docter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "-> MedicalNote : " + docter + " | " + timestamp + " | " + description;
    }
}
