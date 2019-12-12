package net;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/11 21:29
 */
public class Request {
    private String method;
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap<>();

    /**
     * 添加请求头
     *
     * @param key
     * @param value
     */
    public void addHeaders(String key, String value) {
        headers.put(key, value);
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
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
}
