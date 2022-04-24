package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * 用户模块业务接口
 * @author Bill Yin
 * @date 2022/4/10
 * @version 1.0
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user
     */
    void reg(User user);
}
