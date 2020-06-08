package com.hnd.community.bean;

import lombok.Data;

@Data
public class SysResult {
    // 表示状态码的数字
    private Integer status;
    // 携带详细信息的字符串
    private String msg;
    // 携带的各种数据
    private Object data;

}
