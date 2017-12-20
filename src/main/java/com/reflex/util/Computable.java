package com.reflex.util;

/**
 * @author: xuyongjian
 * @date: 2017/11/26
 */
public interface Computable<A,V> {
    /**
     * 执行函数
     * @param a
     * @return
     * @throws InterruptedException
     */
    V compute(A a) throws InterruptedException;
}
