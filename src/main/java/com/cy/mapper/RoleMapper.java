package com.cy.mapper;

import com.cy.bean.Tblpower;
import com.cy.bean.Tblrole;
import com.cy.bean.Tblrolepowercombination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    public int  addRole(@Param("roleName")String roleName,
                        @Param("info")String info);
    public List<Tblrole> searchRoleList();
    public List<Tblrole> searchRoleListLimit(@Param("startRow")int startRow,
                                             @Param("pageSize")int pageSize);
    public int delRole(@Param("roleID")long roleID);
    public int modifyRole(@Param("roleName")String roleName,
                          @Param("info")String info,
                          @Param("roleID")long roleID);
    public List<Tblpower>searchPowerList();//所有的权限列表
    public List<Tblrolepowercombination>searchRolePowerList(@Param("roleID")long roleID);
    public int delRolePower(@Param("roleID")long roleID);
    public int addRolePower(@Param("roleID")long roleID,
                            @Param("powerID")long powerID);
}
