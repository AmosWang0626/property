package cn.zut.core.service.impl;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.TariffCompanyService;
import cn.zut.dao.persistence.TariffCompanyBillMapper;
import cn.zut.facade.enums.PaymentWayEnum;
import cn.zut.facade.request.TariffCompanyBillRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/23
 */
@Service
public class TariffCompanyServiceImpl implements TariffCompanyService {

    @Resource
    private TariffCompanyBillMapper tariffCompanyBillMapper;

    @Override
    public GenericResponse paymentRecord(TariffCompanyBillRequest tariffCompanyBillRequest) {


//        tariffCompanyBillMapper.insert();

        return null;
    }

    /**
     * 模拟缴费状态
     *
     * @param paymentWayEnum 缴费方式
     * @return 缴费状态
     */
    private GenericResponse virtualPaymentStatus(PaymentWayEnum paymentWayEnum) {
        ExceptionCode exceptionCode;

        int randomNum = new Random().nextInt(120);

        // 不同的缴费方式如果失败则会有不同的失败原因
        switch (paymentWayEnum) {
            case CASH:
                if (randomNum == 1) {

                } else if (randomNum == 2) {

                } else if (randomNum == 3) {

                } else if (randomNum == 4) {

                }
                exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_INSUFFICIENT_BALANCE;
                break;

            case ALI_PAY:
                exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_INSUFFICIENT_BALANCE;
                break;

            case WE_CHAT:
                exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_INSUFFICIENT_BALANCE;
                break;

            case BANK_CARD:
                exceptionCode = ExceptionCode.PAYMENT_ALI_PAY_INSUFFICIENT_BALANCE;
                break;

            default:
                exceptionCode = ExceptionCode.PAYMENT_WAY_NOT_EXIST;
                break;
        }

        return new GenericResponse(new ExceptionMessage(exceptionCode));

    }

}
