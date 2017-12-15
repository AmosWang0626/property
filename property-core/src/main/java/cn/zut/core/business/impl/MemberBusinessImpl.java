package cn.zut.core.business.impl;

import cn.zut.common.check.GeneralCheck;
import cn.zut.common.response.GenericResponse;
import cn.zut.common.security.DESEncryptionUtil;
import cn.zut.common.security.EncryptionUtil;
import cn.zut.common.util.EncryptUtil;
import cn.zut.common.util.RandomUtil;
import cn.zut.core.business.MemberBusiness;
import cn.zut.core.constant.PrivateConstant;
import cn.zut.core.service.MemberService;
import cn.zut.dao.entity.LoginInfoEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.LoginInfoMapper;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.dao.search.MemberSearch;
import cn.zut.facade.exception.ExceptionCode;
import cn.zut.facade.exception.ExceptionMessage;
import cn.zut.facade.request.ForgetPwdForm;
import cn.zut.facade.request.LoginForm;
import cn.zut.facade.request.RegisterForm;
import cn.zut.facade.response.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * PROJECT: catherine
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@Component("memberBusiness")
public class MemberBusinessImpl implements MemberBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberBusinessImpl.class);

    @SuppressWarnings("all")
    @Resource
    private MemberMapper memberMapper;
    @SuppressWarnings("all")
    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Resource
    private MemberService memberService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GenericResponse register(RegisterForm registerForm) {

        String phoneNo = registerForm.getPhoneNo();

        // 校验手机号格式
        if (!GeneralCheck.isPhoneNo(phoneNo)) {
            return new GenericResponse<>(new ExceptionMessage(ExceptionCode.PHONE_NO_ERROR, phoneNo));
        }
        // 校验手机号码是否已经被注册
        if (getMemberByPhoneNo(phoneNo) != null) {
            return new GenericResponse<>(new ExceptionMessage(ExceptionCode.PHONE_IS_EXIST, phoneNo));
        }

        return memberService.save(registerForm);
    }

    @Override
    public GenericResponse<LoginVO> login(LoginForm loginForm) {
        String phoneNo = loginForm.getPhoneNo();
        String password = loginForm.getPassword();

        MemberEntity memberEntity = getMemberByPhoneNo(phoneNo);
        // 校验手机号码是否已经被注册
        if (memberEntity == null) {
            return new GenericResponse<>(new ExceptionMessage(ExceptionCode.PHONE_IS_NOT_EXIST, phoneNo));
        }

        LoginInfoEntity loginInfoEntity = loginInfoMapper.selectById(memberEntity.getMemberId());
        if (loginInfoEntity == null) {
            return new GenericResponse<>(new ExceptionMessage(ExceptionCode.MEMBER_DATA_EXCEPTION, phoneNo));
        }

        String encryptPassword = EncryptionUtil.encrypt(loginInfoEntity.getSalt() + password, EncryptionUtil.MD5);
        if (!loginInfoEntity.getPassword().equals(encryptPassword)) {
            return new GenericResponse<>(new ExceptionMessage(ExceptionCode.MEMBER_PASSWORD_ERROR));
        }
        // 设置最后一次登录时间
        loginInfoEntity.setLastLoginTime(new Date());
        loginInfoMapper.update(loginInfoEntity);

        LoginVO loginVO = new LoginVO();
        loginVO.setPhoneNo(EncryptUtil.encryPhoneNo(phoneNo));
        loginVO.setNickName(memberEntity.getNickName());
        loginVO.setToken(DESEncryptionUtil.encrypt(String.valueOf(memberEntity.getMemberId()), PrivateConstant.TOKEN_ENCRYPT));
        return new GenericResponse<>(loginVO);
    }

    @Override
    public GenericResponse updatePwd(ForgetPwdForm forgetPwdForm) {
        MemberSearch memberSearch = new MemberSearch();
        memberSearch.setNickName(forgetPwdForm.getName());
        memberSearch.setPhoneNo(forgetPwdForm.getPhone());
        MemberEntity memberEntity = memberMapper.selectByExample(memberSearch);
        if (memberEntity == null) {
            return new GenericResponse<>(new ExceptionMessage(ExceptionCode.NICK_NAME_PHONE_NOT_NULL));
        }
        Long memberId = memberEntity.getMemberId();
        LoginInfoEntity loginInfoEntity = loginInfoMapper.selectById(memberId);
        // 生成密码盐
        String salt = RandomUtil.generateLetterString(PrivateConstant.SALT_LENGTH);
        String encryptPassword = EncryptionUtil.encrypt(salt + forgetPwdForm.getPassword(), EncryptionUtil.MD5);
        loginInfoEntity.setSalt(salt);
        loginInfoEntity.setPassword(encryptPassword);
        loginInfoEntity.setLastLoginTime(new Date());
        loginInfoMapper.update(loginInfoEntity);

        return GenericResponse.SUCCESS;
    }

    private MemberEntity getMemberByPhoneNo(String phoneNo) {
        MemberSearch memberSearch = new MemberSearch();
        memberSearch.setPhoneNo(phoneNo);
        return memberMapper.selectByExample(memberSearch);
    }
}
