package com.etc.pfs.entity;

public class SubJect {
    private String id;
    private String s_name;

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", s_name='" + s_name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public SubJect(String id, String s_name) {
        this.id = id;
        this.s_name = s_name;
    }

    public SubJect() {
        super();
    }
}
