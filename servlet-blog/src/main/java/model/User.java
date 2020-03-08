package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/8 22:16
 */
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private Date createTime;
}
