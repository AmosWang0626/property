package cn.zut.test;

import cn.zut.core.business.TariffBillBusiness;
import cn.zut.core.service.TariffCompanyService;
import cn.zut.dao.entity.*;
import cn.zut.dao.persistence.*;
import cn.zut.facade.enums.*;
import cn.zut.facade.request.TariffCompanyBillRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 * DATE: 2017/12/11
 *
 * @author DaoYuanWang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-jdbc.xml"})
public class PropertyTariffTest {

    private static Logger LOGGER = LoggerFactory.getLogger(PropertyTariffTest.class);

    @Resource
    private TariffBillMapper tariffBillMapper;
    @Resource
    private TariffBillPlanMapper tariffBillPlanMapper;
    @Resource
    private TariffCompanyBillMapper tariffCompanyBillMapper;
    @Resource
    private TariffCompanyMapper tariffCompanyMapper;
    @Resource
    private TariffStandardMapper tariffStandardMapper;
    @Resource
    private TariffConsumeMapper tariffConsumeMapper;

    @Test
    public void tariffCompanyMapper() {
        TariffCompanyEntity companyEntity = new TariffCompanyEntity();
        companyEntity.setName("上海水务");
        companyEntity.setAddress("黄埔区西藏南路1222号");
        companyEntity.setBusiness(BusinessTypeEnum.WATER);
        companyEntity.setTelephone("021-195632120");
        companyEntity.setOrganizationCode("56489514-4");
        companyEntity.setLegalName("龙龙");
        companyEntity.setEstablish("1983年");
        companyEntity.setRegisterCapital("2000万");
        companyEntity.setStatus(true);
        companyEntity.setCreateTime(new Date());
        companyEntity.setUpdateTime(new Date());
        tariffCompanyMapper.insert(companyEntity);

        LOGGER.info("-----------------------------------------插入成功-----------------------------------------");
    }

    @Test
    public void tariffCompanyBillMapper() {
        TariffCompanyBillEntity companyBillEntity = new TariffCompanyBillEntity();
        companyBillEntity.setCompanyId(1L);
        companyBillEntity.setMemberId(10000L);
        companyBillEntity.setExternalNo(12222L);
        companyBillEntity.setPaymentAmount(new BigDecimal("2000.00"));
        companyBillEntity.setPaymentWay(PaymentWayEnum.BANK_CARD);
        companyBillEntity.setPaymentStatus(PaymentStatusEnum.PAY_SUCCESS);
        companyBillEntity.setPaymentDate(new Date());
        companyBillEntity.setErrorCode("");
        companyBillEntity.setErrorMessage("");
        companyBillEntity.setCreateTime(new Date());
        tariffCompanyBillMapper.insert(companyBillEntity);

        LOGGER.info("-----------------------------------------插入成功-----------------------------------------");
    }

    @Test
    public void tariffStandardMapper() {
        TariffStandardEntity standardEntity = new TariffStandardEntity();
        standardEntity.setBusiness(BusinessTypeEnum.WATER);
        standardEntity.setLevel(BusinessLevelEnum.WATER_COMPANY);
        standardEntity.setUnitPrice(new BigDecimal("30.00"));
        standardEntity.setOverdueRate(new BigDecimal("0.001"));
        standardEntity.setStartTime(new Date());
        standardEntity.setEndTime(new Date());
        standardEntity.setStatus(true);
        standardEntity.setCreateTime(new Date());
        standardEntity.setUpdateTime(new Date());
        tariffStandardMapper.insert(standardEntity);
        LOGGER.info("-----------------------------------------插入成功-----------------------------------------");
    }

    @Test
    public void tariffBillMapper() {
        TariffBillEntity billEntity = new TariffBillEntity();
        billEntity.setMemberId(10000L);
        billEntity.setHouseNo("1301");
        billEntity.setBusiness(BusinessTypeEnum.WATER);
        billEntity.setStandardId(1L);
        billEntity.setBillStatus(BillStatusEnum.REPAYING);
        billEntity.setUsedTotal(new BigDecimal("30.00"));
        billEntity.setUnitPrice(new BigDecimal("30.00"));
        billEntity.setOverdueRate(new BigDecimal("0.001"));
        billEntity.setBillAmount(new BigDecimal("900.00"));
        billEntity.setBillMonth("2018-03");
        billEntity.setBillStartDate(new Date());
        billEntity.setBillEndDate(new Date());
        billEntity.setExpand("");
        billEntity.setCreateTime(new Date());
        billEntity.setUpdateTime(new Date());
        tariffBillMapper.insert(billEntity);
        LOGGER.info("-----------------------------------------插入成功-----------------------------------------");
    }

    @Test
    public void tariffBillPlanMapper() {
        TariffBillPlanEntity billPlanEntity = new TariffBillPlanEntity();
        billPlanEntity.setBillNo(1L);
        billPlanEntity.setMemberId(10000L);
        billPlanEntity.setBillStatus(BillStatusEnum.REPAYING);
        billPlanEntity.setRepayDate(new Date());
        billPlanEntity.setSettleDate(new Date());
        billPlanEntity.setOverdueDays(2);
        billPlanEntity.setBillAmount(new BigDecimal("900.00"));
        billPlanEntity.setLateChargeAmt(BigDecimal.ZERO);
        billPlanEntity.setBillAmountPaid(BigDecimal.ZERO);
        billPlanEntity.setLateChargeAmtPaid(BigDecimal.ZERO);
        billPlanEntity.setBillAmountOffer(BigDecimal.ZERO);
        billPlanEntity.setLateChargeAmtOffer(BigDecimal.ZERO);
        billPlanEntity.setExpand("");
        billPlanEntity.setCreateTime(new Date());
        billPlanEntity.setUpdateTime(new Date());
        tariffBillPlanMapper.insert(billPlanEntity);
        LOGGER.info("-----------------------------------------插入成功-----------------------------------------");
    }

    @Test
    public void tariffConsumeMapper() {
        TariffConsumeEntity tariffConsumeEntity = new TariffConsumeEntity();
        tariffConsumeEntity.setMemberId(10000L);
        tariffConsumeEntity.setOperator("操作员AAA");
        tariffConsumeEntity.setBusiness(BusinessTypeEnum.WATER);
        tariffConsumeEntity.setStandardId(1000L);
        tariffConsumeEntity.setUsedTotal(new BigDecimal("30.00"));
        tariffConsumeEntity.setUnitPrice(new BigDecimal("30.00"));
        tariffConsumeEntity.setConsumeExpand("豫R:095c7");
        tariffConsumeEntity.setConsumeAmount(new BigDecimal(1000));
        tariffConsumeEntity.setPaymentStatus(PaymentStatusEnum.PAY_SUCCESS);
        tariffConsumeEntity.setExpand("666666666666");
        tariffConsumeEntity.setCreateTime(new Date());
        tariffConsumeEntity.setUpdateTime(new Date());
        tariffConsumeMapper.insert(tariffConsumeEntity);
    }

    @Resource
    private TariffBillBusiness tariffBillBusiness;

    @Test
    public void generateTariffBill() {
        tariffBillBusiness.generateMonthBill();
    }

    @Resource
    private TariffCompanyService tariffCompanyService;

    @Test
    public void paymentRecord() {
        TariffCompanyBillRequest tariffCompanyBillRequest = new TariffCompanyBillRequest();
        tariffCompanyBillRequest.setCompanyId(66666L);
        tariffCompanyBillRequest.setExternalNo("65168523323");
        tariffCompanyBillRequest.setMemberId(10000L);
        tariffCompanyBillRequest.setPaymentAmount(new BigDecimal(1000));
        tariffCompanyBillRequest.setPaymentWay(PaymentWayEnum.ALI_PAY);
        tariffCompanyService.paymentRecord(tariffCompanyBillRequest);
    }
}
