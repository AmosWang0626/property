package cn.zut.core.service.impl;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.TariffCompanyService;
import cn.zut.dao.entity.TariffCompanyBillEntity;
import cn.zut.dao.persistence.TariffCompanyBillMapper;
import cn.zut.facade.enums.PaymentStatusEnum;
import cn.zut.facade.enums.PaymentWayEnum;
import cn.zut.facade.request.TariffCompanyBillRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/23
 */
@Service("tariffCompanyService")
public class TariffCompanyServiceImpl implements TariffCompanyService {

    @Resource
    private TariffCompanyBillMapper tariffCompanyBillMapper;

    /**
     * 即便是加上处理中状态,也只需操作TariffCompanyBillEntity数据,
     * 查询交易状态时,如果处理完成,就更新其他表支付状态;未完成则继续等待,再次查询...
     */
    @Override
    public GenericResponse paymentRecord(TariffCompanyBillRequest tariffCompanyBillRequest) {
        if (tariffCompanyBillRequest.getExternalNo() == null
                || tariffCompanyBillRequest.getMemberId() == null
                || tariffCompanyBillRequest.getCompanyId() == null) {
            return GenericResponse.ERROR_PARAM;
        }

        // 支付方式不能为 null
        PaymentWayEnum paymentWay = tariffCompanyBillRequest.getPaymentWay();
        if (paymentWay == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.MEMBER_DATA_EXCEPTION));
        }
        // 支付金额必须大于 0
        if (BigDecimal.ZERO.compareTo(tariffCompanyBillRequest.getPaymentAmount()) >= 0) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PAYMENT_AMOUNT_MUST_MORE_THAN_ZERO));
        }

        TariffCompanyBillEntity tariffCompanyBillEntity = new TariffCompanyBillEntity();
        BeanUtils.copyProperties(tariffCompanyBillRequest, tariffCompanyBillEntity);

        // 模拟真实扣款, 拿到扣款结果, 并记录
        GenericResponse virtualPaymentResponse = virtualPaymentStatus(paymentWay);
        if (virtualPaymentResponse.success()) {
            tariffCompanyBillEntity.setPaymentStatus(PaymentStatusEnum.PAY_SUCCESS);
        } else {
            tariffCompanyBillEntity.setPaymentStatus(PaymentStatusEnum.PAY_FAIL);
            tariffCompanyBillEntity.setErrorCode(virtualPaymentResponse.getRespCode());
            tariffCompanyBillEntity.setErrorMessage(virtualPaymentResponse.getRespMsg());
        }

        tariffCompanyBillEntity.setPaymentDate(new Date());
        tariffCompanyBillEntity.setCreateTime(new Date());
        tariffCompanyBillMapper.insert(tariffCompanyBillEntity);

        return virtualPaymentResponse;
    }

    /**
     * 模拟缴费状态
     *
     * @param paymentWayEnum 缴费方式
     * @return 缴费状态
     */
    private GenericResponse virtualPaymentStatus(PaymentWayEnum paymentWayEnum) {
        ExceptionCode exceptionCode = null;

        int randomNum = new Random().nextInt(120);

        // 不同的缴费方式如果失败则会有不同的失败原因
        switch (paymentWayEnum) {
            case CASH:
                if (randomNum == 1) {
                    exceptionCode = ExceptionCode.PAYMENT_CASH_NOTCH;
                } else if (randomNum == 2) {
                    exceptionCode = ExceptionCode.PAYMENT_CASH_COUNTERFEIT_MONEY;
                }
                break;

            case ALI_PAY:
                if (randomNum == 1) {
                    exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_PWD_ERROR;
                } else if (randomNum == 2) {
                    exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_INSUFFICIENT_BALANCE;
                } else if (randomNum == 3) {
                    exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_NETWORK_ERROR;
                } else if (randomNum == 4) {
                    exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_OVER_QUOTA;
                }
                break;

            case WE_CHAT:
                if (randomNum == 1) {
                    exceptionCode = ExceptionCode.PAYMENT_WE_CHAT_PWD_ERROR;
                } else if (randomNum == 2) {
                    exceptionCode = ExceptionCode.PAYMENT_WE_CHAT_INSUFFICIENT_BALANCE;
                } else if (randomNum == 3) {
                    exceptionCode = ExceptionCode.PAYMENT_WE_CHAT_NETWORK_ERROR;
                } else if (randomNum == 4) {
                    exceptionCode = ExceptionCode.PAYMENT_WE_CHAT_OVER_QUOTA;
                }
                break;

            case BANK_CARD:
                if (randomNum == 1) {
                    exceptionCode = ExceptionCode.PAYMENT_BANK_CARD_PWD_ERROR;
                } else if (randomNum == 2) {
                    exceptionCode = ExceptionCode.PAYMENT_BANK_CARD_INSUFFICIENT_BALANCE;
                } else if (randomNum == 3) {
                    exceptionCode = ExceptionCode.PAYMENT_BANK_CARD_OVER_QUOTA;
                }
                break;

            default:
                break;
        }

        if (exceptionCode == null) {
            return GenericResponse.SUCCESS;
        }

        return new GenericResponse(new ExceptionMessage(exceptionCode));
    }

}
