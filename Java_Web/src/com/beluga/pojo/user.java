package com.beluga.pojo;

/**
 * @author Beluga
 * @createTime 2022/8/7 -- 21:49
 */
public class user {
    private int Id;
    private String username;
    private String pwd;
    private String email;

    public user() {
    }

    public user(int id, String username, String pwd, String email) {
        Id = id;
        this.username = username;
        this.pwd = pwd;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "user{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
