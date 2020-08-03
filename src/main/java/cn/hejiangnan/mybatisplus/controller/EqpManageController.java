package cn.hejiangnan.mybatisplus.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import cn.hejiangnan.mybatisplus.service.IEqpManageService;
import cn.hejiangnan.mybatisplus.entity.EqpManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cn.hejiangnan.mybatisplus.entity.dto.Result;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
* @ClassName: EqpManageController
* @Description: 设备管理前端控制器
* @Author: hejiangnan
* @Date: 2020-08-03
*/
@Api(tags = {"设备管理"})
@RestController
@RequestMapping("//eqp-manage")
public class EqpManageController {

    @Resource
    private IEqpManageService eqpManageService;

    /**
     * 新增设备管理
     *
     * @param eqpManage 设备管理
     * @return Result
     * @author hejiangnan
     * @date 2020-08-03
     */
    @ApiOperation(value = "新增设备管理")
    @PostMapping()
    public Result add(@RequestBody EqpManage eqpManage){
        eqpManageService.add(eqpManage);
        return Result.success();
    }

    /**
     * 删除设备管理
     *
     * @param id 主键
     * @return Result
     * @author hejiangnan
     * @date 2020-08-03
     */
    @ApiOperation(value = "删除设备管理")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Integer id){
        eqpManageService.delete(id);
        return Result.success();
    }

    /**
     * 更新设备管理
     *
     * @param eqpManage 设备管理
     * @return Result
     * @author hejiangnan
     * @date 2020-08-03
     */
    @ApiOperation(value = "更新设备管理")
    @PutMapping()
    public Result update(@RequestBody EqpManage eqpManage){
        eqpManageService.updateData(eqpManage);
        return Result.success();
    }

    /**
     * 查询设备管理分页数据
     *
     * @param page  页码
     * @param limit 每页条数
     * @return Result
     * @author hejiangnan
     * @date 2020-08-03
     */
    @ApiOperation(value = "查询设备管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "limit", value = "每页条数")
    })
    @GetMapping()
    public Result findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer limit){
        return Result.success(eqpManageService.findListByPage(page, limit));
    }

    /**
     * 根据id查询设备管理
     *
     * @param id 主键
     * @return Result
     * @author hejiangnan
     * @date 2020-08-03
     */
    @ApiOperation(value = "根据id查询设备管理")
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        return Result.success(eqpManageService.findById(id));
    }
}
