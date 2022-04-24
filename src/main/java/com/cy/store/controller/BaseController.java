package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层类的基类
 * @author Bill Yin
 * @date 2022/4/11
 */
public class BaseController {
    /** 操作成功的状态码 */
    public static final int OK = 200;

    //请求处理方法。这个方法的返回值就是需要传递给前端的数据
    @ExceptionHandler(ServiceException.class) //统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }
        return result;
    }
}
