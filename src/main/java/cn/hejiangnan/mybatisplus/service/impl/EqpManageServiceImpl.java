package cn.hejiangnan.mybatisplus.service.impl;

import cn.hejiangnan.mybatisplus.entity.EqpManage;
import cn.hejiangnan.mybatisplus.mapper.EqpManageMapper;
import cn.hejiangnan.mybatisplus.service.IEqpManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import lombok.extern.slf4j.Slf4j;

/**
* @ClassName: EqpManageServiceImpl
* @Description: 设备管理接口实现类
* @Author: hejiangnan
* @Date: 2020-08-03
*/
@Slf4j
@Service
public class EqpManageServiceImpl extends ServiceImpl<EqpManageMapper, EqpManage> implements IEqpManageService {

    /**
     * 查询设备管理分页数据
     *
     * @param page  页码
     * @param limit 每页条数
     * @return IPage<EqpManage>
     * @author hejiangnan
     * @date 2020-08-03
     */
    @Override
    public  IPage<EqpManage> findListByPage(Integer page, Integer limit){
        IPage<EqpManage> wherePage = new Page<>(page, limit);
        EqpManage where = new EqpManage();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    /**
     * 添加设备管理
     *
     * @param eqpManage 设备管理
     * @return int
     * @author hejiangnan
     * @date 2020-08-03
     */
    @Override
    public int add(EqpManage eqpManage){
        return baseMapper.insert(eqpManage);
    }

    /**
     * 删除设备管理
     *
     * @param id 主键
     * @return int
     * @author hejiangnan
     * @date 2020-08-03
     */
    @Override
    public int delete(Integer id){
        return baseMapper.deleteById(id);
    }

    /**
     * 修改设备管理
     *
     * @param eqpManage 设备管理
     * @return int
     * @author hejiangnan
     * @date 2020-08-03
     */
    @Override
    public int updateData(EqpManage eqpManage){
        return baseMapper.updateById(eqpManage);
    }

    /**
     * 根据id查询设备管理
     *
     * @param id 主键
     * @return EqpManage
     * @author hejiangnan
     * @date 2020-08-03
     */
    @Override
    public EqpManage findById(Integer id){
        return  baseMapper.selectById(id);
    }
}
