package TP3.EX2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import TP3.EX2.base.Appointment;
import TP3.EX2.base.AppointmentStatus;
import TP3.EX2.base.Doctor;
import TP3.EX2.base.MedicalNote;
import TP3.EX2.base.Patient;

public class TesterGUI extends JFrame {

    private DefaultListModel<Patient> patientsModel = new DefaultListModel<>();
    private DefaultListModel<Doctor> doctorsModel = new DefaultListModel<>();
    private DefaultListModel<Appointment> appointmentsModel = new DefaultListModel<>();
    private DefaultListModel<MedicalNote> notesModel = new DefaultListModel<>();

    private JList<Patient> listPatients;
    private JList<Doctor> listDoctors;
    private JList<Appointment> listAppointments;
    private JList<MedicalNote> listNotes;

    private JTextField tfPUser, tfPPass, tfPName, tfPAddress, tfPEmail, tfPPhone;
    private JTextField tfDUser, tfDPass, tfDName, tfDAddress, tfDEmail, tfDPhone, tfDSpecialty;

    private JComboBox<AppointmentStatus> cbApptStatus;

    public TesterGUI() {
        setTitle("Medical Appointment System");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Patients", createPatientsPanel());
        tabs.add("Doctors", createDoctorsPanel());
        tabs.add("Appointments", createAppointmentsPanel());
        tabs.add("Medical Records", createRecordsPanel());

        add(tabs);
    }

    // ───────────────────────────────
    // ✔ PATIENTS PANEL
    // ───────────────────────────────

    private JPanel createPatientsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        listPatients = new JList<>(patientsModel);
        listPatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(new JScrollPane(listPatients), BorderLayout.CENTER);
        panel.add(createPatientForm(), BorderLayout.EAST);

        return panel;
    }

    private JPanel createPatientForm() {
        JPanel form = new JPanel(new GridLayout(10, 1, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Add Patient"));

        tfPUser = new JTextField();
        tfPPass = new JTextField();
        tfPName = new JTextField();
        tfPAddress = new JTextField();
        tfPEmail = new JTextField();
        tfPPhone = new JTextField();

        form.add(new JLabel("Username"));
        form.add(tfPUser);
        form.add(new JLabel("Password"));
        form.add(tfPPass);
        form.add(new JLabel("Name"));
        form.add(tfPName);
        form.add(new JLabel("Address"));
        form.add(tfPAddress);
        form.add(new JLabel("Email"));
        form.add(tfPEmail);
        form.add(new JLabel("Phone"));
        form.add(tfPPhone);

        JButton btnAdd = new JButton("Add Patient");
        btnAdd.addActionListener(e -> addPatient());
        form.add(btnAdd);

        return form;
    }

    private void addPatient() {
        Patient p = new Patient(
                tfPUser.getText(),
                tfPPass.getText(),
                tfPName.getText(),
                tfPAddress.getText(),
                tfPEmail.getText(),
                tfPPhone.getText());

        patientsModel.addElement(p);
        JOptionPane.showMessageDialog(this, "Patient added!");
    }

    // ───────────────────────────────
    // ✔ DOCTORS PANEL
    // ───────────────────────────────

    private JPanel createDoctorsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        listDoctors = new JList<>(doctorsModel);
        listDoctors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(new JScrollPane(listDoctors), BorderLayout.CENTER);
        panel.add(createDoctorForm(), BorderLayout.EAST);

        return panel;
    }

    private JPanel createDoctorForm() {
        JPanel form = new JPanel(new GridLayout(12, 1, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Add Doctor"));

        tfDUser = new JTextField();
        tfDPass = new JTextField();
        tfDName = new JTextField();
        tfDAddress = new JTextField();
        tfDEmail = new JTextField();
        tfDPhone = new JTextField();
        tfDSpecialty = new JTextField();

        form.add(new JLabel("Username"));
        form.add(tfDUser);
        form.add(new JLabel("Password"));
        form.add(tfDPass);
        form.add(new JLabel("Name"));
        form.add(tfDName);
        form.add(new JLabel("Address"));
        form.add(tfDAddress);
        form.add(new JLabel("Email"));
        form.add(tfDEmail);
        form.add(new JLabel("Phone"));
        form.add(tfDPhone);
        form.add(new JLabel("Specialty"));
        form.add(tfDSpecialty);

        JButton btnAdd = new JButton("Add Doctor");
        btnAdd.addActionListener(e -> addDoctor());
        form.add(btnAdd);

        return form;
    }

    private void addDoctor() {
        Doctor d = new Doctor(
                tfDUser.getText(),
                tfDPass.getText(),
                tfDName.getText(),
                tfDAddress.getText(),
                tfDEmail.getText(),
                tfDPhone.getText(),
                tfDSpecialty.getText());

        doctorsModel.addElement(d);
        JOptionPane.showMessageDialog(this, "Doctor added!");
    }

    // ───────────────────────────────
    // ✔ APPOINTMENTS PANEL – FIXED VERSION
    // ───────────────────────────────

    private JPanel createAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        listAppointments = new JList<>(appointmentsModel);
        listAppointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(new JScrollPane(listAppointments), BorderLayout.CENTER);
        panel.add(createAppointmentForm(), BorderLayout.EAST);

        return panel;
    }

    private JPanel createAppointmentForm() {

        JPanel form = new JPanel(new GridLayout(10, 1, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Create Appointment"));

        cbApptStatus = new JComboBox<>(AppointmentStatus.values());

        JButton btnCreate = new JButton("Create Appointment");
        btnCreate.addActionListener(e -> createAppointment());

        form.add(new JLabel("Select Patient (from left list)"));
        form.add(new JLabel("Select Doctor (from left list)"));

        form.add(new JLabel("Status"));
        form.add(cbApptStatus);
        form.add(btnCreate);

        return form;
    }

    private void createAppointment() {
        Patient p = listPatients.getSelectedValue();
        Doctor d = listDoctors.getSelectedValue();

        if (p == null || d == null) {
            JOptionPane.showMessageDialog(this, "Please select a patient and a doctor from the lists.");
            return;
        }

        Appointment appt = new Appointment(
                p,
                d,
                LocalDateTime.now(),
                (AppointmentStatus) cbApptStatus.getSelectedItem());

        appointmentsModel.addElement(appt);
        JOptionPane.showMessageDialog(this, "Appointment created!");
    }

    // ───────────────────────────────
    // ✔ MEDICAL NOTES PANEL – FIXED
    // ───────────────────────────────

    private JPanel createRecordsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        listNotes = new JList<>(notesModel);
        listNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(new JScrollPane(listNotes), BorderLayout.CENTER);
        panel.add(createNoteForm(), BorderLayout.EAST);

        return panel;
    }

    private JPanel createNoteForm() {
        JPanel form = new JPanel(new GridLayout(10, 1, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Add Medical Note"));

        JTextArea taDescription = new JTextArea();
        taDescription.setLineWrap(true);

        JButton btnAdd = new JButton("Add Note");
        btnAdd.addActionListener(e -> {
            Doctor d = listDoctors.getSelectedValue();
            Patient p = listPatients.getSelectedValue();

            if (d == null || p == null) {
                JOptionPane.showMessageDialog(this, "Select patient and doctor from left lists.");
                return;
            }

            MedicalNote note = new MedicalNote(
                    d,
                    taDescription.getText(),
                    LocalDateTime.now());

            notesModel.addElement(note);
            JOptionPane.showMessageDialog(this, "Note added!");
        });

        form.add(new JLabel("Note Description:"));
        form.add(new JScrollPane(taDescription));
        form.add(btnAdd);

        return form;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TesterGUI().setVisible(true));
    }
}
