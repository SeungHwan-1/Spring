package com.ohgiraffers.common;

import org.springframework.stereotype.Component;


public class MemberDTO {

    private int sequence;
    private String id;
    private String pwd;
    private String name;


    public MemberDTO(int sequence, String id, String pwd, String name) {
        this.sequence = sequence;
        this.id = id;
        this.pwd = pwd;
        this.name = name;

    }

    public MemberDTO() {
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "sequence=" + sequence +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
