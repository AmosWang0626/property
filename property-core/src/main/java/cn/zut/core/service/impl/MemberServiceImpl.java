package cn.zut.core.service.impl;

import cn.zut.common.request.RegisterRequest;
import cn.zut.common.response.GenericResponse;
import cn.zut.common.security.EncryptionUtil;
import cn.zut.common.util.GenericIdUtil;
import cn.zut.common.util.RandomUtil;
import cn.zut.core.constant.PrivateConstant;
import cn.zut.core.service.MemberService;
import cn.zut.dao.entity.LoginInfoEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.LoginInfoMapper;
import cn.zut.dao.persistence.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GenericResponse save(RegisterRequest registerRequest) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.init();
        Long memberId = GenericIdUtil.genericMemberId();
        memberEntity.setMemberId(memberId);
        memberEntity.setPhoneNo(registerRequest.getPhoneRegister());
        memberEntity.setNickName(registerRequest.getNameRegister());

        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.init();
        loginInfoEntity.setMemberId(memberId);
        // 生成密码盐
        String salt = RandomUtil.generateLetterString(PrivateConstant.SALT_LENGTH);
        String encryptPassword = EncryptionUtil.encrypt(salt + registerRequest.getPwdRegister(), EncryptionUtil.MD5);
        loginInfoEntity.setSalt(salt);
        loginInfoEntity.setPassword(encryptPassword);

        memberMapper.insert(memberEntity);
        loginInfoMapper.insert(loginInfoEntity);

        return GenericResponse.SUCCESS;
    }
}
