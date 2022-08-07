package com.cy.bean;


public class Tbluser {

  private long userId;
  private String userAcc;
  private String userPwd;
  private String userImgUrl;
  private String userName;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public String getUserImgUrl() {
    return userImgUrl;
  }

  public void setUserImgUrl(String userImgUrl) {
    this.userImgUrl = userImgUrl;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "Tbluser{" +
            "userId=" + userId +
            ", userAcc='" + userAcc + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", userImgUrl='" + userImgUrl + '\'' +
            ", userName='" + userName + '\'' +
            '}';
  }
}
