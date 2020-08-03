package ${package.Controller};

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cn.hejiangnan.mybatisplus.entity.dto.Result;

import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
* @ClassName: ${table.controllerName}
* @Description: ${table.comment!}前端控制器
* @Author: ${author}
* @Date: ${date}
*/
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}/</#if><#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    /**
     * 新增${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return Result
     * @author ${author}
     * @date ${date}
     */
    @ApiOperation(value = "新增${table.comment!}")
    @PostMapping()
    public Result add(@RequestBody ${entity} ${entity?uncap_first}){
        ${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first});
        return Result.success();
    }

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return Result
     * @author ${author}
     * @date ${date}
     */
    @ApiOperation(value = "删除${table.comment!}")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Integer id){
        ${(table.serviceName?substring(1))?uncap_first}.delete(id);
        return Result.success();
    }

    /**
     * 更新${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return Result
     * @author ${author}
     * @date ${date}
     */
    @ApiOperation(value = "更新${table.comment!}")
    @PutMapping()
    public Result update(@RequestBody ${entity} ${entity?uncap_first}){
        ${(table.serviceName?substring(1))?uncap_first}.updateData(${entity?uncap_first});
        return Result.success();
    }

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page  页码
     * @param limit 每页条数
     * @return Result
     * @author ${author}
     * @date ${date}
     */
    @ApiOperation(value = "查询${table.comment!}分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "limit", value = "每页条数")
    })
    @GetMapping()
    public Result findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer limit){
        return Result.success(${(table.serviceName?substring(1))?uncap_first}.findListByPage(page, limit));
    }

    /**
     * 根据id查询${table.comment!}
     *
     * @param id 主键
     * @return Result
     * @author ${author}
     * @date ${date}
     */
    @ApiOperation(value = "根据id查询${table.comment!}")
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        return Result.success(${(table.serviceName?substring(1))?uncap_first}.findById(id));
    }
}
</#if>