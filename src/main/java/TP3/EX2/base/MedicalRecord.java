package TP3.EX2.base;

import java.util.ArrayList;

public class MedicalRecord {
    protected Patient patient;
    protected ArrayList<MedicalNote> medicalNotes;

    public MedicalRecord(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void addMedicalNote(MedicalNote medicalNote) {
        this.medicalNotes.add(medicalNote);
    }

    public void removemedicalNote(MedicalNote medicalNote) {
        this.medicalNotes.removeIf(item -> item == medicalNote);
    }

    @Override
    public String toString() {

        return "-> MedicalRecord : " + patient + " | " + medicalNotes;
    }

}
