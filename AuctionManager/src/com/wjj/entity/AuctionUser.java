package com.wjj.entity;

public class AuctionUser {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userCardNo;
    private String userTel;
    private String userAddress;
    private String userPostNumber;

    public AuctionUser(){}
    public AuctionUser(Integer userId, String userName, String userPassword, String userCardNo, String userTel, String userAddress, String userPostNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCardNo = userCardNo;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.userPostNumber = userPostNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserCardNo() {
        return userCardNo;
    }

    public void setUserCardNo(String userCardNo) {
        this.userCardNo = userCardNo;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPostNumber() {
        return userPostNumber;
    }

    public void setUserPostNumber(String userPostNumber) {
        this.userPostNumber = userPostNumber;
    }
}
