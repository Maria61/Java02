package com.demo;

/**
 * @author Maria
 * @program homework01
 * @date 2020/4/15 16:20
 */
public class Student {
    private String sno;
    private String name;
    public Student() {}
    public Student(String sno,String name)
    {
        this.setSno(sno);
        this.setName(name);
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name =name;
    }

}