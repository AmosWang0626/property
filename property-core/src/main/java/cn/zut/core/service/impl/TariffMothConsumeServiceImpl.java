package cn.zut.core.service.impl;

import cn.zut.core.service.TariffMothConsumeService;
import cn.zut.dao.entity.TariffMonthConsumeEntity;
import cn.zut.dao.persistence.TariffMonthConsumeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("tariffMothConsumeService")
public class TariffMothConsumeServiceImpl implements TariffMothConsumeService {

    @Resource
    private TariffMonthConsumeMapper tariffMonthConsumeMapper;

    /**
     * 获取所以用户信息
     */
    @Override
    public List<TariffMonthConsumeEntity> getAllUsers() {
        return tariffMonthConsumeMapper.selectListByExample(null);
    }

    /**
     * 修改指定用户用水量设置
     */
    @Override
    public boolean updateByWater(Integer memberId, BigDecimal water) {
        TariffMonthConsumeEntity tariffMonthConsumeEntity = tariffMonthConsumeMapper.selectById(memberId);
        tariffMonthConsumeEntity.setWater(water);
        int flag = tariffMonthConsumeMapper.update(tariffMonthConsumeEntity);
        return flag > 0;
    }

    /**
     * 修改指定用户电费设置
     */
    @Override
    public boolean updateByElectric(Integer memberId, BigDecimal electric) {
        TariffMonthConsumeEntity tariffMonthConsumeEntity = tariffMonthConsumeMapper.selectById(memberId);
        tariffMonthConsumeEntity.setElectric(electric);
        int flag = tariffMonthConsumeMapper.update(tariffMonthConsumeEntity);
        return flag > 0;
    }

    /**
     * 修改指定用户物业费业务
     */
    @Override
    public boolean updateByProperty(Integer memberId, BigDecimal property) {
        TariffMonthConsumeEntity tariffMonthConsumeEntity = tariffMonthConsumeMapper.selectById(memberId);
        tariffMonthConsumeEntity.setProperty(property);
        int flag = tariffMonthConsumeMapper.update(tariffMonthConsumeEntity);
        return flag > 0;
    }

    /**
     * 修改指定用户网费业务
     */
    @Override
    public boolean updateByInternet(Integer memberId, Boolean internet) {
        TariffMonthConsumeEntity tariffMonthConsumeEntity = tariffMonthConsumeMapper.selectById(memberId);
        tariffMonthConsumeEntity.setNetwork(internet);
        int flag = tariffMonthConsumeMapper.update(tariffMonthConsumeEntity);
        return flag > 0;
    }

}
