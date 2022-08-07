package com.cy.bean;

public class Tblrolepowercombination {
    private long rolepowerID;
    private long roleID;
    private long powerID;
    private String powerName;
    private long parentID;
    private String url;

    public Tblrolepowercombination() {
    }

    public Tblrolepowercombination(long rolepowerID, long roleID, long powerID, String powerName, long parentID, String url) {
        this.rolepowerID = rolepowerID;
        this.roleID = roleID;
        this.powerID = powerID;
        this.powerName = powerName;
        this.parentID = parentID;
        this.url = url;
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
        return "Tblrolepowercombination{" +
                "rolepowerID=" + rolepowerID +
                ", roleID=" + roleID +
                ", powerID=" + powerID +
                ", powerName='" + powerName + '\'' +
                ", parentID=" + parentID +
                ", url='" + url + '\'' +
                '}';
    }
}
