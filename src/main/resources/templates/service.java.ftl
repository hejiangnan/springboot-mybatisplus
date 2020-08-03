package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @ClassName: ${table.serviceName}
* @Description: ${table.comment!}接口类
* @Author: ${author}
* @Date: ${date}
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page  页码
     * @param limit 每页条数
     * @return IPage<${entity}>
     * @author ${author}
     * @date ${date}
     */
    IPage<${entity}> findListByPage(Integer page, Integer limit);

    /**
     * 添加${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     * @author ${author}
     * @date ${date}
     */
    int add(${entity} ${entity?uncap_first});

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return int
     * @author ${author}
     * @date ${date}
     */
    int delete(Integer id);

    /**
     * 修改${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     * @author ${author}
     * @date ${date}
     */
    int updateData(${entity} ${entity?uncap_first});

    /**
     * 根据id查询${table.comment!}
     *
     * @param id id
     * @return ${entity}
     * @author ${author}
     * @date ${date}
     */
    ${entity} findById(Integer id);
}
</#if>
