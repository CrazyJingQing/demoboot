package com.cy.bean;


public class Tblrole {

  private long roleID;
  private String roleName;
  private String info;

  public Tblrole() {
  }

  public Tblrole(long roleID, String roleName, String info) {
    this.roleID = roleID;
    this.roleName = roleName;
    this.info = info;
  }

  public long getRoleID() {
    return roleID;
  }

  public void setRoleID(long roleID) {
    this.roleID = roleID;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "Tblrole{" +
            "roleID=" + roleID +
            ", roleName='" + roleName + '\'' +
            ", info='" + info + '\'' +
            '}';
  }
}
