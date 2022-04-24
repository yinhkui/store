package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bill Yin
 * @date 2022/4/11
 */
@RestController//= @Controller + @ResponseBody
//@Controller
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    //@ResponseBody 表示此方法的响应结果以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }
//    @RequestMapping("reg")
//    //@ResponseBody 表示此方法的响应结果以json格式进行数据的响应给到前端
//    public JsonResult<Void> reg(User user) {
//        //创建响应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        } catch (InsertException e) {
//            result.setState(5000);
//            result.setMessage("数据插入异常");
//        }
//        return result;
//    }
}
