package com.cy.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cy.bean.Tblpower;
import com.cy.bean.Tblrole;
import com.cy.bean.Tblrolepowercombination;
import com.cy.bean.Tbluser;
import com.cy.service.RoleService;
import com.cy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/userListView")
    public String userListView(){
        return "userlist";
    }
    @RequestMapping("/shuttlewindow")
    public String shuttlewindow(){
            return "shuttlewindow";
    }
    @RequestMapping(value = "/userlist",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String userlist(int page, int pageSize){
        //当前页
        int curretPage=page;
        //每页显示条数 pageSize
        //起始行
        int startRow=(curretPage-1)*pageSize;
        //分页查询
        List<Tbluser>tbluserListLimit=userService.searchUserListLimit(startRow,pageSize);
        //查总条数
        List<Tbluser>tbluserList=userService.searchUserList();
        int findCount=tbluserList.size();
        Map map=new HashMap<String,Object>();
        map.put("tbluserListLimit",tbluserListLimit);
        map.put("findCount",findCount);
        String json = JSON.toJSONString(map);
        return json;
    }
    //用户删除
    @RequestMapping("/delUser")
    public @ResponseBody
    String delUser(String userAcc){
        boolean delUser=userService.delUser(userAcc);
        if(delUser){
            return "1";
        }else {
            return "0";
        }
    }
    //用户添加
    @RequestMapping("/AddUser")
    public  String register(MultipartFile fname, HttpServletRequest request , String addUserName, String addUserAcc, String addUserPwd, HttpServletResponse response){//文件都放在这里面
        String fn=fname.getOriginalFilename();//从传过来的文件获取文件名
        System.out.println(fn);
        try {
            //访问的url
            String url5=request.getServletContext().getRealPath("/upload");//获取请求的上下文中的真实路径
            System.out.println(url5);
            File file=new File(url5);
            if(!file.exists()){
                file.mkdir();
            }
            fname.transferTo(new File(url5+"/"+fn)); //保存File 文件转接
            String userImgUrl=url5+"/"+fn;
            boolean addUser=userService.addUser(addUserAcc,addUserPwd,userImgUrl,addUserName);
            if(addUser){
                response.getWriter().println("success");
                return "userlist";
            }else {
                response.getWriter().println("fail");
                return "userlist";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "userlist";
    }
    //用户修改 modifyUser
    @RequestMapping("/modifyUser")
    public  String modifyUser(MultipartFile modifyfname, HttpServletRequest request , String modifyUserName, String modifyUserAcc, String modifyUserPwd, HttpServletResponse response){//文件都放在这里面
        String fn=modifyfname.getOriginalFilename();//从传过来的文件获取文件名
        System.out.println(fn);
        try {
            //访问的url
            String url5=request.getServletContext().getRealPath("/upload");//获取请求的上下文中的真实路径
            System.out.println(url5);
            File file=new File(url5);
            if(!file.exists()){
                file.mkdir();
            }
            modifyfname.transferTo(new File(url5+"/"+fn)); //保存File 文件转接
            String userImgUrl=url5+"/"+fn;
            boolean modifyUser=userService.modifyUser(modifyUserName,modifyUserPwd,userImgUrl,modifyUserAcc);
            if(modifyUser){
                response.getWriter().println("success");
                return "userlist";
            }else {
                response.getWriter().println("fail");
                return "userlist";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

            return "userlist";
    }
    @RequestMapping("/roleManageView")
    public String rolemanage(){
            return "rolemanage";
    }
    @RequestMapping(value = "/rolemanagelist",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String rolemanagelist(int page, int pageSize){
        //当前页
        int curretPage=page;
        //每页显示条数 pageSize
        //起始行
        int startRow=(curretPage-1)*pageSize;
        //分页查询
        List<Tblrole>tblroleListLimit=roleService.searchRoleListLimit(startRow,pageSize);
        //查总条数
        List<Tblrole>tblroleList=roleService.searchRoleList();
        int findCount=tblroleList.size();
        Map map=new HashMap<String,Object>();
        map.put("tblroleListLimit",tblroleListLimit);
        map.put("findCount",findCount);
        String json = JSON.toJSONString(map);
        return json;
    }
    @RequestMapping("/addRole")
    public @ResponseBody
    String addRole(String roleName, String info){
        boolean addRole=roleService.addRole(roleName, info);
        if(addRole){
            return "1";
        }else {
            return "0";
        }

    }
    //用户删除
    @RequestMapping("/delRole")
    public @ResponseBody
    String delRole(long roleID){
        boolean delRole=roleService.delRole(roleID);
        if(delRole){
            return "1";
        }else {
            return "0";
        }
    }
    @RequestMapping("/modifyRole")
    public @ResponseBody
    String modifyRole(String roleName, String info, long roleID){
        boolean modifyRole=roleService.modifyRole(roleName, info, roleID);
        if(modifyRole){
            return "1";
        }else {
            return "0";
        }
    }
    //所需要的权限列表
    @RequestMapping(value = "/needPowerList",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String needPowerList(long roleID){
        List<Tblpower>tblpowerList=roleService.searchPowerList();
        List<Tblrolepowercombination>tblrolepowercombinationList=roleService.searchRolePowerList(roleID);
        Map map =new HashMap<String,Object>();
        map.put("tblpowerList",tblpowerList);
        map.put("tblrolepowercombinationList",tblrolepowercombinationList);
        String json=JSON.toJSONString(map);
        return json;

    }
    //将需要保存的数据数组传过来进行处理
    @RequestMapping("/saveRolePower")
    public @ResponseBody
    String saveRolePower(long roleID, String powerListArray){
        JSON.parseArray(powerListArray);
        for (int i=0;i<JSON.parseArray(powerListArray).size();i++){
            System.out.println(JSON.parseArray(powerListArray).get(i));
            System.out.println("x");
        }
        return "1";

    }
    @RequestMapping(value = "/doLogin",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String doLogin(String uname, String upwd){
        Tbluser tbluser=userService.doLogin(uname,upwd);
        String  uobj= JSONArray.toJSONString(tbluser);
        return  uobj;
    }

    @RequestMapping(value = "/allUserlist",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String allUserlist(){
        List<Tbluser>tbluserListLimit=userService.searchUserList();
        String json = JSON.toJSONString(tbluserListLimit);
        return json;
    }
    //用户删除
    @RequestMapping("/newDelUser")
    public @ResponseBody
    String newDelUser(String userAcc){
        boolean delUser=userService.delUser(userAcc);
        if(delUser){
            return "1";
        }else {
            return "0";
        }
    }
    @RequestMapping("/newModifyUser")
    public @ResponseBody
    String newModifyUser(Tbluser user){
        System.out.println(user);
        boolean newModifyUser=userService.newModifyUser(user.getUserName(),user.getUserPwd(),user.getUserAcc());
        if(newModifyUser){
            return "1";
        }else {
            return "0";
        }

    }
    @RequestMapping("/newAddUser")
    public @ResponseBody
    String newAddUser(Tbluser user){
        System.out.println(user);
        boolean newModifyUser=userService.newAddUser(user.getUserName(),user.getUserPwd(),user.getUserAcc());
        if(newModifyUser){
            return "1";
        }else {
            return "0";
        }

    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }



}
