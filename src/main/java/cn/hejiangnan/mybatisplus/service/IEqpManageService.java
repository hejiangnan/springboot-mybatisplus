package cn.hejiangnan.mybatisplus.service;

import cn.hejiangnan.mybatisplus.entity.EqpManage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @ClassName: IEqpManageService
* @Description: 设备管理接口类
* @Author: hejiangnan
* @Date: 2020-08-03
*/
public interface IEqpManageService extends IService<EqpManage> {

    /**
     * 查询设备管理分页数据
     *
     * @param page  页码
     * @param limit 每页条数
     * @return IPage<EqpManage>
     * @author hejiangnan
     * @date 2020-08-03
     */
    IPage<EqpManage> findListByPage(Integer page, Integer limit);

    /**
     * 添加设备管理
     *
     * @param eqpManage 设备管理
     * @return int
     * @author hejiangnan
     * @date 2020-08-03
     */
    int add(EqpManage eqpManage);

    /**
     * 删除设备管理
     *
     * @param id 主键
     * @return int
     * @author hejiangnan
     * @date 2020-08-03
     */
    int delete(Integer id);

    /**
     * 修改设备管理
     *
     * @param eqpManage 设备管理
     * @return int
     * @author hejiangnan
     * @date 2020-08-03
     */
    int updateData(EqpManage eqpManage);

    /**
     * 根据id查询设备管理
     *
     * @param id id
     * @return EqpManage
     * @author hejiangnan
     * @date 2020-08-03
     */
    EqpManage findById(Integer id);
}
