package com.cy.mapper;

import com.cy.bean.Tbluser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public Tbluser searchUser(@Param("userAcc") String userAcc);

    public int addUser(@Param("userAcc") String userAcc,
                       @Param("userPwd") String userPwd,
                       @Param("userImgUrl") String userImgUrl,
                       @Param("userName") String userName);

    public List<Tbluser> searchUserList();

    public List<Tbluser> searchUserListLimit(@Param("startRow") int startRow,
                                             @Param("pageSize") int pageSize);

    public int delUser(@Param("userAcc") String userAcc);

    public int modifyUser(@Param("userName") String userName,
                          @Param("userPwd") String userPwd,
                          @Param("userImgUrl") String userImgUrl,
                          @Param("userAcc") String userAcc);

    public Tbluser doLogin(@Param("userAcc") String userAcc,
                           @Param("userPwd") String userPwd);

    public int newModifyUser(@Param("userName") String userName,
                             @Param("userPwd") String userPwd,
                             @Param("userAcc") String userAcc);
    public int newAddUser(@Param("userName") String userName,
                          @Param("userPwd") String userPwd,
                          @Param("userAcc") String userAcc);
}