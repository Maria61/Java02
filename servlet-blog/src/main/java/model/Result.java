package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/7 11:17
 */
@Setter
@Getter
@ToString
public class Result {
    //请求是否成功
    private boolean success;
    //错误码
    private String code;
    //错误信息
    private String message;
    //返回数据
    private Object data;


}
