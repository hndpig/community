package com.hnd.community.controller;

import com.github.pagehelper.Page;
import com.hnd.community.bean.Msg;
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
}
