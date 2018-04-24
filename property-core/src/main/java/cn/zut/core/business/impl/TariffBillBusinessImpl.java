package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.common.util.DateUtil;
import cn.zut.common.util.GenericIdUtil;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.core.service.TariffCompanyService;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffCompanyEntity;
import cn.zut.dao.entity.TariffConsumeEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import cn.zut.dao.persistence.TariffBillMapper;
import cn.zut.dao.persistence.TariffCompanyMapper;
import cn.zut.dao.persistence.TariffConsumeMapper;
import cn.zut.dao.persistence.TariffStandardMapper;
import cn.zut.facade.enums.BillStatusEnum;
import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.PaymentStatusEnum;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;
import cn.zut.facade.request.TariffBillRequest;
import cn.zut.facade.request.TariffCompanyBillRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * PROJECT: property
 * DESCRIPTION: TariffBillBusiness
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Component("tariffBillBusiness")
public class TariffBillBusinessImpl implements TariffBillBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(TariffBillBusinessImpl.class);

    @Resource
    private TariffBillMapper tariffBillMapper;
    @Resource
    private TariffConsumeMapper tariffConsumeMapper;
    @Resource
    private TariffStandardMapper tariffStandardMapper;
    @Resource
    private TariffCompanyMapper tariffCompanyMapper;

    @Resource
    private TariffCompanyService tariffCompanyService;

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
    public GenericResponse consumeConfirm(Long operatorMemberId, ConsumeConfirmRequest consumeConfirmRequest) {
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(consumeConfirmRequest.getBusiness());
        tariffStandardEntity.setLevel(consumeConfirmRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);
        // 先拿到标准
        if (tariffStandardEntity == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        // 再拿到收费公司
        TariffCompanyEntity tariffCompanyEntity = new TariffCompanyEntity();
        tariffCompanyEntity.setBusiness(consumeConfirmRequest.getBusiness());
        tariffCompanyEntity = tariffCompanyMapper.selectByExample(tariffCompanyEntity);
        if (tariffCompanyEntity == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_COMPANY_BUSINESS_NOT_EXIST));
        }

        BigDecimal consumeAmount = tariffStandardEntity.getUnitPrice().multiply(consumeConfirmRequest.getUsedTotal());
        String consumeNo = GenericIdUtil.genericConsumeNo();

        TariffConsumeEntity tariffConsumeEntity = new TariffConsumeEntity();
        BeanUtils.copyProperties(consumeConfirmRequest, tariffConsumeEntity);
        tariffConsumeEntity.setConsumeNo(consumeNo);
        tariffConsumeEntity.setConsumeAmount(consumeAmount);
        tariffConsumeEntity.setStandardId(tariffStandardEntity.getStandardId());
        tariffConsumeEntity.setUnitPrice(tariffStandardEntity.getUnitPrice());
        // 设置操作人信息
        tariffConsumeEntity.setOperator(consumeConfirmRequest.getOperator() + "[" + operatorMemberId + "]");
        tariffConsumeEntity.setCreateTime(new Date());

        // 请求支付公司接口
        TariffCompanyBillRequest tariffCompanyBillRequest = new TariffCompanyBillRequest();
        tariffCompanyBillRequest.setMemberId(consumeConfirmRequest.getMemberId());
        tariffCompanyBillRequest.setCompanyId(tariffCompanyEntity.getCompanyId());
        tariffCompanyBillRequest.setExternalNo(consumeNo);
        tariffCompanyBillRequest.setPaymentAmount(consumeAmount);
        tariffCompanyBillRequest.setPaymentWay(consumeConfirmRequest.getPaymentWay());
        GenericResponse paymentRecordResponse = tariffCompanyService.paymentRecord(tariffCompanyBillRequest);
        // 保存消费记录
        if (paymentRecordResponse.success()) {
            tariffConsumeEntity.setPaymentStatus(PaymentStatusEnum.PAY_SUCCESS);
            tariffConsumeMapper.insert(tariffConsumeEntity);

            return GenericResponse.SUCCESS;
        }

        tariffConsumeEntity.setPaymentStatus(PaymentStatusEnum.PAY_FAIL);
        tariffConsumeEntity.setExpand("错误码: " + paymentRecordResponse.getRespCode() + ", 错误原因: " + paymentRecordResponse.getRespMsg());
        tariffConsumeMapper.insert(tariffConsumeEntity);

        return paymentRecordResponse;
    }

    @Override
    public GenericResponse generateMonthBill() {
        // 生成月度账单（物业费 / 水费 / 电费 / 网费）

        // 遍历房间: 拿到房间面积,计算物业费; 拿到水/电/网使用量,计算相应费用
        BigDecimal useTotal = new BigDecimal(new Random().nextInt(30) + 50);

        TariffBillRequest tariffBillRequest = new TariffBillRequest();
        // 房间号 || 业主编号
        tariffBillRequest.setHouseNo("1#101");
        tariffBillRequest.setMemberId(10000L);
        // 使用量(暂时随机)
        tariffBillRequest.setUsedTotal(useTotal);
        // 业务类型 + 业务等级
        tariffBillRequest.setBusiness(BusinessTypeEnum.PROPERTY);
        tariffBillRequest.setLevel(BusinessLevelEnum.PROPERTY_ONE);

        TariffBillEntity tariffBillEntity;
        try {
            tariffBillEntity = generateBill(tariffBillRequest);
        } catch (RuntimeException e) {
            LOGGER.error("当前资费标准不存在", e);
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        tariffBillMapper.insert(tariffBillEntity);

        return GenericResponse.SUCCESS;
    }

    @Override
    public GenericResponse billEntry(Long operatorMemberId, TariffBillRequest tariffBillRequest) {
        // 根据户号,设置memberId
        String houseNo = tariffBillRequest.getHouseNo();
        Long memberId = 10008L;
        tariffBillRequest.setMemberId(memberId);
        tariffBillRequest.setOperator(tariffBillRequest.getOperator() + "[" + operatorMemberId + "]");

        TariffBillEntity tariffBillEntity;
        try {
            tariffBillEntity = generateBill(tariffBillRequest);
        } catch (RuntimeException e) {
            LOGGER.error("当前资费标准不存在", e);
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        tariffBillMapper.insert(tariffBillEntity);

        return GenericResponse.SUCCESS;
    }

    @Override
    public SimplePageResult<TariffBillEntity> pageBillByModel(PageModel<TariffBillEntity> pageModel) {
        List<TariffBillEntity> tariffBillEntities = tariffBillMapper.selectListPageByExample(pageModel);
        int memberCount = tariffBillMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<TariffBillEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(memberCount);
        pageResult.setRows(tariffBillEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

    private TariffBillEntity generateBill(TariffBillRequest tariffBillRequest) throws RuntimeException {
        TariffBillEntity tariffBillEntity = new TariffBillEntity();

        // 房间号 || 业主用户编号 || 面积或使用量 || 业务类型 || 业务等级 || 备注
        tariffBillEntity.setHouseNo(tariffBillRequest.getHouseNo());
        tariffBillEntity.setMemberId(tariffBillRequest.getMemberId());
        tariffBillEntity.setUsedTotal(tariffBillRequest.getUsedTotal());
        tariffBillEntity.setBusiness(tariffBillRequest.getBusiness());
        tariffBillEntity.setLevel(tariffBillRequest.getLevel());
        tariffBillEntity.setExpand(tariffBillRequest.getExpand());

        // 由于标准是会变的,所以注意取其最新标准
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(tariffBillRequest.getBusiness());
        tariffStandardEntity.setLevel(tariffBillRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);
        if (tariffStandardEntity == null) {
            throw new RuntimeException("当前资费标准不存在 "
                    + tariffBillRequest.getBusiness() + " ------ " + tariffBillRequest.getLevel());
        }
        tariffBillEntity.setStandardId(tariffStandardEntity.getStandardId());

        // 生成账单字段（本月生成上月账单）
        tariffBillEntity.setBillMonth(DateUtil.getMonth());
        tariffBillEntity.setBillStartDate(DateUtil.getPreMonthFirstDay());
        tariffBillEntity.setBillEndDate(DateUtil.getPreMonthLastDay());

        tariffBillEntity.setBillStatus(BillStatusEnum.REPAYING);
        tariffBillEntity.setUnitPrice(tariffStandardEntity.getUnitPrice());
        tariffBillEntity.setOverdueRate(tariffStandardEntity.getOverdueRate());
        tariffBillEntity.setBillAmount(tariffBillRequest.getUsedTotal().multiply(tariffStandardEntity.getUnitPrice()));
        tariffBillEntity.setCreateTime(new Date());

        return tariffBillEntity;
    }
}
