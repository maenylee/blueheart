package com.heart.blue.manage.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
@Data
@Accessors(chain = true)
@TableName("tb_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;
    public static final String ID = "id";
    public static final String PARENT_ID = "parent_id";
    public static final String PERM_NAME = "perm_name";
    public static final String PERM_TYPE = "perm_type";
    public static final String PERM_NUM = "perm_num";
    public static final String ICON = "icon";
    public static final String URL = "url";
    public static final String STATUS = "status";
    public static final String GMT_CREATE = "gmt_create";
    public static final String GMT_MODIFY = "gmt_modify";
    /**
     * {name:"主键"}
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * {name:"父ID。0表示根ID"}
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * {name:"权限名称"}
     */
    @TableField("perm_name")
    private String permName;

    /**
     * {name:"权限标识"}
     */
    @TableField("perm_type")
    private String permType;

    /**
     * {name:"权限编号"}
     */
    @TableField("perm_num")
    private String permNum;

    /**
     * {name:"图标"}
     */
    @TableField("icon")
    private String icon;

    /**
     * {name:"访问url"}
     */
    @TableField("url")
    private String url;

    /**
     * {name:"权限状态 0：启用 1：禁用"}
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
