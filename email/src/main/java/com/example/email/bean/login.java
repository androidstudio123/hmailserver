package com.example.email.bean;

//@Entity
//@Table(name="login")
public class login {
//    @Id
//@Column(name="username")
    private int id;
    private String username;
//    @Column(name="password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
