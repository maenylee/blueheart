package com.heart.blue.manage.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Danny
 * @since 2019-11-02
 */
@Data
@Accessors(chain = true)
@TableName("tb_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * {name:"主键"}
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * {name:"请求地址"}
     */
    @TableField("request_url")
    private String requestUrl;
    /**
     * {name:"请求Ip"}
     */
    @TableField("request_ip")
    private String requestIp;
    /**
     * {name:"方法名称"}
     */
    @TableField("method_name")
    private String methodName;
    /**
     * {name:"方法描述"}
     */
    @TableField("method_desc")
    private String methodDesc;
    /**
     * {name:"请求参数"}
     */
    @TableField("request_param")
    private String requestParam;
    /**
     * {name:"执行方法时间"}
     */
    @TableField("exec_time")
    private Integer execTime;
    /**
     * {name:"执行方法错误信息"}
     */
    @TableField("error_message")
    private String errorMessage;
    /**
     * {name:"创建时间"}
     */
    @TableField("gmt_create")
    private Date gmtCreate;
    /**
     * {name:"更新时间"}
     */
    @TableField("gmt_modify")
    private Date gmtModify;


    public static final String ID = "id";

    public static final String REQUEST_URL = "request_url";

    public static final String REQUEST_IP = "request_ip";

    public static final String METHOD_NAME = "method_name";

    public static final String METHOD_DESC = "method_desc";

    public static final String REQUEST_PARAM = "request_param";

    public static final String EXEC_TIME = "exec_time";

    public static final String ERROR_MESSAGE = "error_message";

    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MODIFY = "gmt_modify";

}
