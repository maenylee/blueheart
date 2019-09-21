package com.heart.blue.manage.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRole implements Serializable {

    private static final long serialVersionUID=1L;
    public static final String ID = "id";
    public static final String PARENT_ID = "parent_id";
    public static final String ROLE_NAME = "role_name";
    public static final String ROLE_TYPE = "role_type";
    public static final String ROLE_NUM = "role_num";
    public static final String STATUS = "status";
    public static final String GMT_CREATE = "gmt_create";
    public static final String GMT_MODIFY = "gmt_modify";
    /**
     * {name:"主键"}
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * {name:"父ID.0表示根ID"}
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * {name:"角色名称"}
     */
    @TableField("role_name")
    private String roleName;

    /**
     * {name:"角色标识"}
     */
    @TableField("role_type")
    private String roleType;

    /**
     * {name:"角色编号"}
     */
    @TableField("role_num")
    private String roleNum;

    /**
     * {name:"角色状态 0：启用 1：禁用"}
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
