package com.cy.service.impl;

import com.cy.bean.Tbluser;
import com.cy.mapper.UserMapper;
import com.cy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean searchUser(String userAcc) {
        Tbluser tbluser=userMapper.searchUser(userAcc);
        if (tbluser!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addUser(String userAcc, String userPwd, String userImgUrl,String userName) {
        int num=userMapper.addUser(userAcc,userPwd,userImgUrl,userName);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Tbluser> searchUserList() {
       List<Tbluser>tbluserList=userMapper.searchUserList();
       return tbluserList;
    }

    @Override
    public List<Tbluser> searchUserListLimit(int startRow, int pageSize) {
        List<Tbluser>tbluserList=userMapper.searchUserListLimit(startRow,pageSize);
        return tbluserList;
    }

    @Override
    public boolean delUser(String userAcc) {
        int num=userMapper.delUser(userAcc);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyUser(String userName, String userPwd, String userImgUrl, String userAcc) {
        int num=userMapper.modifyUser(userName, userPwd, userImgUrl, userAcc);
        if(num>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Tbluser doLogin(String userAcc, String userPwd) {
        Tbluser tbluser=userMapper.doLogin(userAcc,userPwd);
            return tbluser;
    }

    @Override
    public boolean newModifyUser(String userName, String userPwd, String userAcc) {
        int num = userMapper.newModifyUser(userName,userPwd,userAcc);
        if (num>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean newAddUser(String userName, String userPwd, String userAcc) {
        int num = userMapper.newAddUser(userName,userPwd,userAcc);
        if (num>0){
            return true;
        }
        return false;
    }
}
