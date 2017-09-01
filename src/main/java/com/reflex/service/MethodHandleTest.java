package com.reflex.service;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/7/12
 */

public class MethodHandleTest {

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        /*无论 obj 最终 是 哪个 实现 类， 下面 这句 都能 正确 调用 到 println 方法 */
        getPrintlnMH(obj).invokeExact("hello world");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {

        /*MethodType： 代表“ 方法 类型”， 包含 了 方法 的 返回 值（ methodType() 的 第一个 参数） 和 具体 参数（ methodType() 第二个 及 以后 的 参数）*/

        MethodType mt = MethodType.methodType(void.class, String.class); /*lookup() 方法 来自于 MethodHandles. lookup， 这句 的 作用 是在 指定 类 中 查找 符合 给定 的 方法 名称、 方法 类型， 并且 符合 调用 权限 的 方法 句柄*/ /*因为 这里 调用 的 是 一个 虚 方法， 按照 Java 语言 的 规则， 方法 第一个 参数 是 隐式 的， 代表 该 方法 的 接收者， 也即 是 this 指向 的 对象， 这个 参数 以前 是 放在 参数 列表 中进 行 传递 的， 而 现在 提供 了 bindTo() 方法 来 完成 这件 事情*/
        return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);

    }


    static class ClassA {
        public void println(String s)
        {
            System.out.println("ClassA:"+s);
        }
    }

}

