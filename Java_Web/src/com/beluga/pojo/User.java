package com.beluga.pojo;

/**
 * @author Beluga
 * @createTime 2022/8/7 -- 21:49
 */
public class User {
    private Integer id;
    private String username;
    private String pwd;
    private String email;

    public User() {
    }

    public User(Integer id, String username, String pwd, String email) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "Id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
