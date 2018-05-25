package cn.zut.test;

import cn.zut.common.enums.BankEnum;
import cn.zut.common.redis.RedisComponent;
import cn.zut.common.util.GenericIdUtil;
import cn.zut.core.business.HttpBusiness;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.MemberMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DATE: 2017/12/11
 *
 * @author DaoYuanWang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-jdbc.xml"})
public class PropertyTest {

    private static Logger LOGGER = LoggerFactory.getLogger(PropertyTest.class);

    @SuppressWarnings("all")
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private HttpBusiness httpBusiness;
    @Resource
    private RedisComponent redisComponent;

    @Test
    public void checkConfig() {
        redisComponent.save("hello", "Mr.Wang Test Set Key");
        String hello = redisComponent.get("hello");
        LOGGER.info("***********PRINT************[{}]", hello);
    }

    @Test
    public void addMember() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(GenericIdUtil.genericMemberId());
        memberEntity.setPhoneNo("18937128861");
        memberMapper.insert(memberEntity);
    }

    @Test
    public void testNormal() {
        LOGGER.info("啦啦啦");
    }

    @Test
    public void testBankNo() {
        // GS 6217231702000816443 JT 40551240115696009 ZX 6217710702187584 BJ 6210300028286406
        String bankName = httpBusiness.getBankName("6228431888888888");
        BankEnum bankEnum = null;
        try {
            bankEnum = StringUtils.isBlank(bankName) ? null : BankEnum.valueOf(bankName);
        } catch (IllegalArgumentException e) {
            LOGGER.info("暂不支持该银行");
        }
        LOGGER.info("银行名称缩写:[{}] && 银行名称中文:[{}]", bankEnum == null ? null : bankEnum.getKey(), bankEnum == null ? null : bankEnum.getValue());
    }
}
