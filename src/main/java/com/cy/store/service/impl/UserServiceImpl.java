package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author Bill Yin
 * @time 2022/4/10 下午8:46
 */
@Service //@Service作用：将当前类对象交给Spring管理，自动创建对象以及对象的维护
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        // 调用mapper的userFindByUsername判断用户是否被注册过
        String username = user.getUsername();
        User resultUser = userMapper.findByUsername(username);
        if (resultUser != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //密码加密处理，md5(串+password+串，即salt+ps+salt)salt为随机数。
        String startPassword = user.getPassword();
        //获取salt
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMD5Password(startPassword, salt);
        user.setSalt(salt);
        user.setPassword(md5Password);
        //补充其他需要的属性isDeleted、日志属性
        user.setIsDelete(0);
        user.setCreatedUser(username);
        user.setModifiedUser(username);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        // 执行用户注册业务功能的实现
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("用户注册过程异常");
        }
    }

    /**
     * 定义一个md5算法加密处理
     */
    private String getMD5Password (String password, String salt) {
        for (int i = 0; i < 3; i++) {
            //MD5加密方法的调用
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes(StandardCharsets.UTF_8)).toUpperCase();
        }
        return password;
    }
}
