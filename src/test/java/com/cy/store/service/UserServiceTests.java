package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Bill Yin
 * @time: 2022/4/9 上午10:44
 */
//@SpringBootTest 表示标注当前类是测试类，不会随同项目一块打包发送
@SpringBootTest
//@RunWith 启动单元测试类，参数必须是SpringRunner实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService iUserService;
    /**
     * 1.@Test修饰
     * 2.返回值为void
     * 3.参数列表不指定任何类型
     * 4.方法访问修饰符必须为public
     */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("Tommy");
            user.setPassword("12345678");
            iUserService.reg(user);
            System.out.println("注册成功");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());;
        }
    }
}
