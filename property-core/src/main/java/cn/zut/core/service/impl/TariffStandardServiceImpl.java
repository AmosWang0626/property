package cn.zut.core.service.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.core.service.TariffStandardService;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import cn.zut.dao.persistence.TariffBillPlanMapper;
import cn.zut.dao.persistence.TariffStandardMapper;
import cn.zut.facade.enums.BusinessTypeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("tariffStandardService")
public class TariffStandardServiceImpl implements TariffStandardService {

    @Resource
    private TariffStandardMapper tariffStandardMapper;

    @Resource
    private TariffBillPlanMapper tariffBillPlanMapper;

    @Override
    public boolean waterSet(TariffStandardEntity tariffStandardEntity) {
        tariffStandardEntity.setBusiness(BusinessTypeEnum.WATER);
        tariffStandardEntity.setStatus(true);
        try {
            statusSet(tariffStandardEntity.getBusiness());
            tariffStandardMapper.insert(tariffStandardEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean internetSet(TariffStandardEntity tariffStandardEntity) {
        tariffStandardEntity.setBusiness(BusinessTypeEnum.NETWORK);
        tariffStandardEntity.setStatus(true);
        try {
            statusSet(tariffStandardEntity.getBusiness());
            tariffStandardMapper.insert(tariffStandardEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean electricSet(TariffStandardEntity tariffStandardEntity) {
        tariffStandardEntity.setBusiness(BusinessTypeEnum.ELECTRICITY);
        tariffStandardEntity.setStatus(true);
        try {
            statusSet(tariffStandardEntity.getBusiness());
            tariffStandardMapper.insert(tariffStandardEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean propertySet(TariffStandardEntity tariffStandardEntity) {
        tariffStandardEntity.setBusiness(BusinessTypeEnum.PROPERTY);
        tariffStandardEntity.setStatus(true);
        try {
            statusSet(tariffStandardEntity.getBusiness());
            tariffStandardMapper.insert(tariffStandardEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public TariffBillPlanEntity getWater(MemberEntity memberEntity, String water) {
        PageModel<TariffBillPlanEntity> pageModel = new PageModel<>();
        TariffBillPlanEntity entity = new TariffBillPlanEntity();
        pageModel.setPage(1);
        pageModel.setRows(10000000);
        List<TariffBillPlanEntity> list = tariffBillPlanMapper.selectListPageByExample(pageModel);
        for (TariffBillPlanEntity e : list) {
            if (e.getMemberId().equals(memberEntity.getMemberId())) {
            }
        }
        return entity;
    }

    private void statusSet(BusinessTypeEnum businessTypeEnum) {
        PageModel<TariffStandardEntity> pageModel = new PageModel<>();
        pageModel.setPage(1);
        pageModel.setRows(10000000);
        List<TariffStandardEntity> list = tariffStandardMapper.selectListPageByExample(pageModel);
        for (TariffStandardEntity e : list) {
            if (e.getBusiness().equals(businessTypeEnum)) {
                e.setStatus(false);
                tariffStandardMapper.update(e);
            }
        }
    }
}
