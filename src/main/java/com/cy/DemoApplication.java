package com.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.cy.mapper")        //getmapper(
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("http://localhost:8888");
    }

}
//1、ssm配置文件 简化  三个框架整合 springmvc mybatis 前端界面
// ->application.properties
//2、依赖整合，ssm jar,多，版本容易冲突
//3、注解的简化，比如说restController,返回json/@controller @responseBody
//4、打包,简化部署 jar ,集成tomcat,
//5、优点 自动配置 ,
//---> 约束>配置>编码
//springboot的优缺点
//优点
//快速构建项目
//对主流开发框架的无配置集成
//项目课独立运行，无需外部依赖Servlet容器
//提供运行时的应用监控
//。。
//缺点
//版本迭代速度很快，一些模块改动很大
//由于不用自己做配置，报错时很难定位
//网上现成的解决方案比较少

