package com.cy.bean;


public class Tblpower {

  private long powerID;
  private String powerName;
  private long parentID;
  private String url;


  public Tblpower() {
  }

  public Tblpower(long powerID, String powerName, long parentID, String url) {
    this.powerID = powerID;
    this.powerName = powerName;
    this.parentID = parentID;
    this.url = url;
  }

  public long getPowerID() {
    return powerID;
  }

  public void setPowerID(long powerID) {
    this.powerID = powerID;
  }

  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }

  public long getParentID() {
    return parentID;
  }

  public void setParentID(long parentID) {
    this.parentID = parentID;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Tblpower{" +
            "powerID=" + powerID +
            ", powerName='" + powerName + '\'' +
            ", parentID=" + parentID +
            ", url='" + url + '\'' +
            '}';
  }
}
