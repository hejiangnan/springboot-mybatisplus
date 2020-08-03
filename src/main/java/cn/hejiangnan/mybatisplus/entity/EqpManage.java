package cn.hejiangnan.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* @ClassName: EqpManage
* @Description: 设备管理
* @Author: hejiangnan
* @Date: 2020-08-03
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_eqp_manage")
@ApiModel(value="EqpManage对象", description="设备管理")
public class EqpManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备种类")
    private String eqpKind;

    @ApiModelProperty(value = "设备名称")
    private String eqpName;

    @ApiModelProperty(value = "设备型号")
    private String eqpModel;

    @ApiModelProperty(value = "设备ID")
    private String eqpId;

    @ApiModelProperty(value = "关联资产")
    private String relatedAssets;

    @ApiModelProperty(value = "设备状态")
    private String eqpStatus;

    @ApiModelProperty(value = "软件版本")
    private String softwareVersion;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "县/区")
    private String county;

    @ApiModelProperty(value = "乡镇/街道")
    private String street;

    @ApiModelProperty(value = "创建人")
    private String createPerson;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    private String updatePerson;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
