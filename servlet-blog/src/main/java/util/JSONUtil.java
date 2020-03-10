package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.SystemException;
import model.Result;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/7 11:04
 */
public class JSONUtil {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    //序列化
    public static String serialize(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON序列化失败："+obj,e);
        }
    }

    //反序列化
    public static <T> T deserialize(String json,Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON字符串反序列化失败："+e);
        }
    }

    public static <T> T deserialize(InputStream is, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try {
            return mapper.readValue(is,clazz);
        } catch (IOException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON字符串反序列化失败："+e);
        }
    }

    public static void main(String[] args) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode("4xxxx");
        result.setMessage("未知错误");
        result.setData("文件数据");
        String json = serialize(result);
        System.out.println(json);
        Result r2 = deserialize(json,Result.class);
        System.out.println(r2);
    }

}
