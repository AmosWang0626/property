/*
 * Heng-You Confidential
 *
 * Copyright (C) 2017 Shanghai Heng-You Information Technology Co., Ltd.
 * All rights reserved.
 *
 * No part of this file may be reproduced or transmitted in any form or by any means,
 * electronic, mechanical, photocopying, recording, or otherwise, without prior
 * written permission of Shanghai Heng-You Information Technology Co., Ltd.
 */

package cn.zut.facade.response;

import java.io.Serializable;

/**
 * PROJECT: property
 *
 * @author DaoyuanWang
 * @date 2018/3/9
 * @apiNote 登录信息VO
 */
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -3216712463111859678L;

    /**
     * 用户token
     */
    private String token;
    /**
     * 加密后的电话号码
     */
    private String phoneNo;
    /**
     * 用户昵称
     */
    private String nickName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
