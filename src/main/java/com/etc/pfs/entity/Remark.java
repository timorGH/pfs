package com.etc.pfs.entity;

public class Remark {
    private String remarkname;
    private float proportion;

    @Override
    public String toString() {
        return "Remark{" +
                ", remarkname='" + remarkname + '\'' +
                ", proportion=" + proportion +
                '}';
    }

    public Remark() {
        super();
    }

    public Remark(String remarkname, float proportion) {
        this.remarkname = remarkname;
        this.proportion = proportion;
    }


    public String getRemarkname() {
        return remarkname;
    }

    public void setRemarkname(String remarkname) {
        this.remarkname = remarkname;
    }

    public float getProportion() {
        return proportion;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }
}
