package com.cy.store.service.ex;

/**
 * 插入语句时候数据库、操作系统宕机产生的插入异常
 * @author: Bill Yin
 * @time: 2022/4/10 下午7:47
 */
public class InsertException extends ServiceException{
    public InsertException() {
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
