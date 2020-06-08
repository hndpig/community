package com.hnd.community.controller;

import com.github.pagehelper.Page;
import com.hnd.community.bean.Msg;
import com.hnd.community.bean.Student;
import com.hnd.community.bean.SysResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Value("#{'${article_type}'.split(',')}")
  //  "#{'${ips}'.split(',')}"
   private List<String> types;



    @RequestMapping("/getType")
    @ResponseBody
    public Msg getType(){
        return Msg.success().add("result",types);
    }

  /*  @RequestMapping("test")
    public String getTest(){

        return "test";
    }*/
    @RequestMapping("/test")
    public  String test(){
        return "sxs";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public  SysResult test2(Student st){
        System.out.println(st);
        SysResult result = new SysResult();
        result.setStatus(200);
        return result;
    }


    @ResponseBody
    @RequestMapping("/test3")
    public  SysResult test3(Student st){
        System.out.println(st);
        SysResult result = new SysResult();
        result.setStatus(200);
        return result;
    }
}
