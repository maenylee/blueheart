package com.heart.blue.manage.entity;

import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Danny
 * @since 2019-08-23
 */
@Data
@Accessors(chain = true)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;
    public static final String ID = "id";
    public static final String USER_NAME = "user_name";
    public static final String REAL_NAME = "real_name";
    public static final String PASSWORD = "password";
    public static final String SEX = "sex";
    public static final String AGE = "age";
    public static final String ADDRESS = "address";
    public static final String QQ = "qq";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String REGISTER_IP = "register_ip";
    public static final String GRADUATE_SCHOOL = "graduate_school";
    public static final String STATUS = "status";
    public static final String GMT_CREATE = "gmt_create";
    public static final String GMT_MODIFY = "gmt_modify";
    /**
     * {name:"主键"}
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * {name:"用户名"}
     */
    @TableField("user_name")
    private String userName;

    /**
     * {name:"真实名称"}
     */
    @TableField("real_name")
    private String realName;

    /**
     * {name:"用户密码"}
     */
    @TableField("password")
    private String password;

    /**
     * {name:"性别"}
     */
    @TableField("sex")
    private Integer sex;

    /**
     * {name:"年龄"}
     */
    @TableField("age")
    private Integer age;

    /**
     * {name:"家庭住址"}
     */
    @TableField("address")
    private String address;

    /**
     * {name:"QQ号"}
     */
    @TableField("qq")
    private String qq;

    /**
     * {name:"手机号"}
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * {name:"注册IP地址"}
     */
    @TableField("register_ip")
    private String registerIp;

    /**
     * {name:"毕业院校"}
     */
    @TableField("graduate_school")
    private String graduateSchool;

    /**
     * {name:"用户状态 0：活跃 1：删除"}
     */
    @TableField("status")
    private Integer status;

    /**
     * {name:"创建时间"}
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * {name:"更新时间"}
     */
    @TableField("gmt_modify")
    private LocalDateTime gmtModify;

}
