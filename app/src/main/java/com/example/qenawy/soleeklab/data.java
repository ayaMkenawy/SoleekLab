package com.example.qenawy.soleeklab;

public class data {
    private String  email,password,confirmpassword;

    public data(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public data(String email, String password, String confirmpassword) {
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }
    public data(){}

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    {

}

}