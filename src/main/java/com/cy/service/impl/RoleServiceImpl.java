package com.cy.service.impl;

import com.cy.bean.Tblpower;
import com.cy.bean.Tblrole;
import com.cy.bean.Tblrolepowercombination;
import com.cy.mapper.RoleMapper;
import com.cy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public boolean addRole(String roleName, String info) {
        int num=roleMapper.addRole(roleName,info);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Tblrole> searchRoleList() {
        List<Tblrole>tblroleList=roleMapper.searchRoleList();
        return tblroleList;
    }

    @Override
    public List<Tblrole> searchRoleListLimit(int startRow, int pageSize) {
        List<Tblrole>tblroleList=roleMapper.searchRoleListLimit(startRow,pageSize);
        return tblroleList;
    }

    @Override
    public boolean delRole(long roleID) {
        int num=roleMapper.delRole(roleID);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyRole(String roleName, String info, long roleID) {
        int num=roleMapper.modifyRole(roleName, info, roleID);
        if(num>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Tblpower> searchPowerList() {
        List<Tblpower>tblpowerList=roleMapper.searchPowerList();
        return tblpowerList;
    }

    @Override
    public List<Tblrolepowercombination> searchRolePowerList(long roleID) {
        List<Tblrolepowercombination>tblrolepowercombinationList=roleMapper.searchRolePowerList(roleID);
        return tblrolepowercombinationList;
    }

    @Override
    public boolean delRolePower(long roleID) {
        return false;
    }

    @Override
    public boolean addRolePower(long roleID) {
        return false;
    }
}
