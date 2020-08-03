package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import lombok.extern.slf4j.Slf4j;

/**
* @ClassName: ${table.serviceImplName}
* @Description: ${table.comment!}接口实现类
* @Author: ${author}
* @Date: ${date}
*/
@Slf4j
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page  页码
     * @param limit 每页条数
     * @return IPage<${entity}>
     * @author ${author}
     * @date ${date}
     */
    @Override
    public  IPage<${entity}> findListByPage(Integer page, Integer limit){
        IPage<${entity}> wherePage = new Page<>(page, limit);
        ${entity} where = new ${entity}();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    /**
     * 添加${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     * @author ${author}
     * @date ${date}
     */
    @Override
    public int add(${entity} ${entity?uncap_first}){
        return baseMapper.insert(${entity?uncap_first});
    }

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return int
     * @author ${author}
     * @date ${date}
     */
    @Override
    public int delete(Integer id){
        return baseMapper.deleteById(id);
    }

    /**
     * 修改${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     * @author ${author}
     * @date ${date}
     */
    @Override
    public int updateData(${entity} ${entity?uncap_first}){
        return baseMapper.updateById(${entity?uncap_first});
    }

    /**
     * 根据id查询${table.comment!}
     *
     * @param id 主键
     * @return ${entity}
     * @author ${author}
     * @date ${date}
     */
    @Override
    public ${entity} findById(Integer id){
        return  baseMapper.selectById(id);
    }
}
</#if>
