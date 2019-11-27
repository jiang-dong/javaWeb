package com.jd.web.Login.domin;

public class User {
    private String Username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.Username = username;
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
