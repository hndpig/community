package com.hnd.community.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * 用于ajax返回json一个标准的返回数据
 */
@Data
public class Msg {
    private int code;//200成功 ，100失败
    private String msg;
    private Map<String ,Object> extend = new HashMap<String,Object>();

    private Msg(){

    }

    public static Msg success(){
        Msg  result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }
    public static Msg fail(){
        Msg  result = new Msg();
        result.setCode(100);
        result.setMsg("处理失败");
        return result;
    }
    public Msg add(String key,Object obj){
        this.getExtend().put(key,obj);
        return this;
    }


}
