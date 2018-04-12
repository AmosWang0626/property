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

package cn.zut.common.exception;

/**
 * DATE: 2018/4/12
 * PROJECT: property
 *
 * @author DaoYuanWang
 */
public class UserTokenException extends RuntimeException {

    private static final long serialVersionUID = -458400119061010307L;

    public UserTokenException(String message) {
        super(message);
    }
}
