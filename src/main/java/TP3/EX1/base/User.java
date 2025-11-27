package TP3.EX1.base;

public abstract class User {
    protected  String username;
    protected  String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
