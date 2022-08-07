package com.cy.bean;


public class Tblrolepower {

  private long rolepowerID;
  private long roleID;
  private long powerID;


  public Tblrolepower() {
  }

  public Tblrolepower(long rolepowerID, long roleID, long powerID) {
    this.rolepowerID = rolepowerID;
    this.roleID = roleID;
    this.powerID = powerID;
  }

  public long getRolepowerID() {
    return rolepowerID;
  }

  public void setRolepowerID(long rolepowerID) {
    this.rolepowerID = rolepowerID;
  }

  public long getRoleID() {
    return roleID;
  }

  public void setRoleID(long roleID) {
    this.roleID = roleID;
  }

  public long getPowerID() {
    return powerID;
  }

  public void setPowerID(long powerID) {
    this.powerID = powerID;
  }

  @Override
  public String toString() {
    return "Tblrolepower{" +
            "rolepowerID=" + rolepowerID +
            ", roleID=" + roleID +
            ", powerID=" + powerID +
            '}';
  }
}
