package com.example.wxchengxu;

public class Classroom {
    private int id;
    private  String classname;
    private  int computers;
    private int service;

    private  boolean usedemo;

    public boolean getUsedemo() {
        return usedemo;
    }

    public void setUsedemo(boolean usedemo) {
        this.usedemo = usedemo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }
}
