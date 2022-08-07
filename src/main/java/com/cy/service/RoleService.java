package com.cy.service;

import com.cy.bean.Tblpower;
import com.cy.bean.Tblrole;
import com.cy.bean.Tblrolepowercombination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleService {
    public boolean addRole(String roleName,String info);
    public List<Tblrole> searchRoleList();
    public List<Tblrole> searchRoleListLimit(int startRow, int pageSize);
    public boolean delRole(long roleID);
    public boolean modifyRole(String roleName, String info, long roleID);
    public List<Tblpower>searchPowerList();
    public List<Tblrolepowercombination>searchRolePowerList(long roleID);
    public boolean delRolePower(long roleID);
    public boolean addRolePower(long roleID);
}
