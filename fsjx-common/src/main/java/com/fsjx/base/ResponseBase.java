package com.fsjx.base;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回参数进行封装
 * Created by lizhen on 2018/4/20 0020.
 */
@ApiModel(value = "ResponseBase",description = "数据返回实体类")
public class ResponseBase {
    //返回状态码
    @ApiModelProperty(value = "状态码",example = "200/500")
    private Integer rtncode;
    //状态信息
    @ApiModelProperty(value = "状态信息",example = "操作成功/操作失败")
    private String rtnmsg;
    //响应数据
    @ApiModelProperty(value = "响应数据",example = "{\n" +
            "  \"updated\": \"2018-05-31T08:42:41.376Z\",\n" +
            "  \"username\": \"王红\"\n" +
            "}")
    private Object rtndata;
    public ResponseBase() {

    }

    public ResponseBase(Integer rtncode, String rtnmsg, Object rtndata) {
        super();
        this.rtncode = rtncode;
        this.rtnmsg = rtnmsg;
        this.rtndata = rtndata;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "rtncode=" + rtncode +
                ", rtnmsg='" + rtnmsg + '\'' +
                ", rtndata=" + rtndata +
                '}';
    }

    public Integer getRtncode() {
        return rtncode;
    }

    public void setRtncode(Integer rtncode) {
        this.rtncode = rtncode;
    }

    public String getRtnmsg() {
        return rtnmsg;
    }

    public void setRtnmsg(String rtnmsg) {
        this.rtnmsg = rtnmsg;
    }

    public Object getRtndata() {
        return rtndata;
    }

    public void setRtndata(Object rtndata) {
        this.rtndata = rtndata;
    }
}
