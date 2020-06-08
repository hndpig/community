package com.hnd.community.bean;




public class Student {
    //学生id
    private String asId;
    //学生性别
    private String sSex;
    //学生名字
    private String sName;
    //学生年龄
    private int age;
    //学生学校
    private String sSchool;
    //学生学号
    private String sNumber;
    //学生电话
    private String sPhone;
    //学生在职状态
    private String sStatus;
    //学生入职时间
    private String sEntryTime;
    //学生实习时长
    private String sWorkingTime;
    //学生所在项目组
    private String sGroup;

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsStatus() {
        return sStatus;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    public String getsEntryTime() {
        return sEntryTime;
    }

    public void setsEntryTime(String sEntryTime) {
        this.sEntryTime = sEntryTime;
    }

    public String getsWorkingTime() {
        return sWorkingTime;
    }

    public void setsWorkingTime(String sWorkingTime) {
        this.sWorkingTime = sWorkingTime;
    }

    public String getsGroup() {
        return sGroup;
    }

    public void setsGroup(String sGroup) {
        this.sGroup = sGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "asId='" + asId + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                ", sSchool='" + sSchool + '\'' +
                ", sNumber='" + sNumber + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sStatus='" + sStatus + '\'' +
                ", sEntryTime='" + sEntryTime + '\'' +
                ", sWorkingTime='" + sWorkingTime + '\'' +
                ", sGroup='" + sGroup + '\'' +
                '}';
    }
}
