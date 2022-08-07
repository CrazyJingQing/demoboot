package com.cy.service;

import com.cy.bean.Tbluser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//@Repository
public interface UserService {
    public boolean searchUser(String userAcc);
    public boolean addUser(String userAcc,String userPwd,String userImgUrl,String userName);
    public List<Tbluser> searchUserList();
    public List<Tbluser> searchUserListLimit(int startRow, int pageSize);
    public boolean delUser(String userAcc);
    public boolean modifyUser(String userName, String userPwd, String userImgUrl, String userAcc);
    public Tbluser doLogin(String userAcc,String userPwd);
    public boolean newModifyUser(String userName, String userPwd, String userAcc);

    public boolean newAddUser(String userName, String userPwd, String userAcc);
}
