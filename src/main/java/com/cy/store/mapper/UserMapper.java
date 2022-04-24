package com.cy.store.mapper;

import com.cy.store.entity.User;

/**
 * @author Bill Yin
 * @date 2022/4/7
 */

/* 用户持久层接口 */
public interface UserMapper {
    /**
     * insert user
     * @param user
     * @return The lines be modified
     */
    Integer insert(User user);

    /**
     * search user by username
     * @param username
     * @return The user be found or null
     */
    User findByUsername(String username);
}
