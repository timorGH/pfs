package com.etc.pfs.entity;

public class UserInfo {
    private String id;
    private String username;
    private String password;
    private String email;
    private String telphone;
    private String fileurl;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telphone='" + telphone + '\'' +
                ", fileurl='" + fileurl + '\'' +
                '}';
    }

    public UserInfo(String id, String username, String password, String email, String telphone, String fileurl) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telphone = telphone;
        this.fileurl = fileurl;
    }

    public UserInfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}
