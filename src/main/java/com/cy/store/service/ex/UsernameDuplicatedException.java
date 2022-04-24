package com.cy.store.service.ex;

/**
 * 用户名占用异常
 * @author: Bill Yin
 * @time: 2022/4/10 下午7:28
 */
public class UsernameDuplicatedException extends ServiceException {
    public UsernameDuplicatedException() {
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    public UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
