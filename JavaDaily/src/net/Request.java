package net;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/11 21:29
 */
public class Request {
    //请求行
    private String method;
    private String url;//eg: http://localhost:9999/XXX?username=stu&password=123
    private String version;
    //请求头
    private Map<String, String> headers = new HashMap<>();
    //请求参数,即将url中的参数单独提取出来储存
    private Map<String, String> parameters = new HashMap<>();


    /**
     * 添加请求头
     *
     * @param key
     * @param value
     */
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    /**
     * 获取某个请求头
     *
     * @param key
     * @return
     */
    public String getHeader(String key) {
        return headers.get(key);
    }

    /**
     * 解析请求参数key1=value1&key2=value2
     *
     * @param parameters
     */
    //现阶段该方法不够严谨
    public void parseParameters(String parameters) {
        String[] parameter = parameters.split("&");
        for (String s : parameter) {
            String[] array = s.split("=");
            addParameter(array[0], array[1]);
        }
    }

    /**
     * 添加请求参数
     *
     * @param key
     * @param value
     */
    public void addParameter(String key, String value) {
        parameters.put(key, value);
    }

    /**
     * 获取请求参数
     *
     * @param key
     * @return
     */
    public String getParameter(String key) {
        return parameters.get(key);
    }


    @Override
    public String toString() {
        return "Request{" +
                "\nmethod='" + method + '\'' +
                ",\n url='" + url + '\'' +
                ",\n version='" + version + '\'' +
                ",\n headers=" + headers +
                "\n, parameters=" + parameters +
                '}';
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
