package com.example.demo;

/** This is the normal employee class where variables are declared and using grtter and setter method
 * and constructor ,this is the concept of encapsulation
 */
class Employee {
    private int id;
    private long no;
    private String emailid;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }
    public Employee(int id,long no,String emailid)
    {
        this.emailid=emailid;
        this.id=id;
        this.no=no;
    }


}
