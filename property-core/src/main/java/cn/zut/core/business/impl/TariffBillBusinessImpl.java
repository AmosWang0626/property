package cn.zut.core.business.impl;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.dao.entity.TariffConsumeEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import cn.zut.dao.persistence.TariffConsumeMapper;
import cn.zut.dao.persistence.TariffStandardMapper;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * PROJECT: property
 * DESCRIPTION: TariffBillBusiness
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Component("tariffBillBusiness")
public class TariffBillBusinessImpl implements TariffBillBusiness {

    @Resource
    private TariffStandardMapper tariffStandardMapper;

    @Resource
    private TariffConsumeMapper tariffConsumeMapper;

    @Override
    public GenericResponse getUnitPrice(ConsumePreviewRequest consumePreviewRequest) {
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(consumePreviewRequest.getBusiness());
        tariffStandardEntity.setLevel(consumePreviewRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);
        if (tariffStandardEntity == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        return new GenericResponse<>(tariffStandardEntity.getUnitPrice());
    }

    @Override
    public GenericResponse consumeConfirm(ConsumeConfirmRequest consumeConfirmRequest) {
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(consumeConfirmRequest.getBusiness());
        tariffStandardEntity.setLevel(consumeConfirmRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);

        if (tariffStandardEntity == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }
        TariffConsumeEntity tariffConsumeEntity = new TariffConsumeEntity();
        BeanUtils.copyProperties(consumeConfirmRequest, tariffConsumeEntity);
        tariffConsumeEntity.setConsumeAmount(tariffStandardEntity.getUnitPrice().multiply(consumeConfirmRequest.getUsedTotal()));
        tariffConsumeEntity.setStandardId(tariffStandardEntity.getStandardId());
        tariffConsumeEntity.setUnitPrice(tariffStandardEntity.getUnitPrice());
        tariffConsumeEntity.setCreateTime(new Date());
        tariffConsumeEntity.setUpdateTime(new Date());
        tariffConsumeMapper.insert(tariffConsumeEntity);

        return GenericResponse.SUCCESS;
    }
}
