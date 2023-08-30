package org.example.model;

public class UserModel {

    private String firstName;
    private String secondName;
    private Integer membershipId;

    public UserModel() {
    }

    public UserModel(String firstName, String secondName, Integer membershipId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.membershipId = membershipId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }
}
