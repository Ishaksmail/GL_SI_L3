package TP3.EX2.base;

public class MedicalStaff extends User {
    protected String name;
    protected String address;
    protected String email;
    protected String phoneNumber;
    protected String role;

    public MedicalStaff(String username, String password, String name, String address, String email,
            String phoneNumber, String role) {
        super(username, password);
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "[MedicalStaff] " + name + " | " + email + "|" + phoneNumber;
    }

}
