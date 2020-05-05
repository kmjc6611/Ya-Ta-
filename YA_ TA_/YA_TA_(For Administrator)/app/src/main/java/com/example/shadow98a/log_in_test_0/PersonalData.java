package com.example.shadow98a.log_in_test_0;


public class PersonalData implements Comparable{
    private String member_id;
    private String member_StudentID;
    private String member_Pwd;
    private String member_Name;
    private String member_Phone;
    private String member_VehicleID;

    public String getMember_id() {
        return member_id;
    }

    public String getMember_StudentID() {
        return member_StudentID;
    }

    public String getMember_Pwd() {
        return member_Pwd;
    }

    public String getMember_Name() {
        return member_Name;
    }

    public String getMember_Phone() {
        return member_Phone;
    }

    public String getMember_VehicleID() {
        return member_VehicleID;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setMember_StudentID(String member_StudentID) {
        this.member_StudentID = member_StudentID;
    }

    public void setMember_Pwd(String member_Pwd) {
        this.member_Pwd = member_Pwd;
    }

    public void setMember_Name(String member_Name) {
        this.member_Name = member_Name;
    }

    public void setMember_Phone(String member_Phone) {
        this.member_Phone = member_Phone;
    }

    public void setMember_VehicleID(String member_VehicleID) {
        this.member_VehicleID = member_VehicleID;
    }

    public int compareTo(Object o){
        PersonalData other =  (PersonalData) o;
        return this.member_StudentID.compareTo(((PersonalData) o).member_StudentID);
    }
}
