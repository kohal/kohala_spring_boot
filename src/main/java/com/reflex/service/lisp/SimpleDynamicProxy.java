package com.reflex.service.lisp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xuyongjian on 2016/12/18.
 */

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied=new RealObject();

    public DynamicProxyHandler() {
    }
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy"+proxy.getClass()+",method: "+method+", args： "+args);
        if(args!=null)
            for (Object arg:args
                 ) {
                System.out.println(" "+arg);

            }
            return method.invoke(proxied, args);

    }
}

public class SimpleDynamicProxy{
    public static void consumer(Interface iface){
        iface.dosometing();
        iface.dosomethingElse("xyj");}
        public static void main(String[] args) {
        RealObject real=new RealObject();
        consumer(real);
        Interface proxy= (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(new SimpleProxy(new RealObject()))
        );
        consumer(proxy);
            long a=10000l;
            Long b=Long.valueOf("1000");
            Long c=Long.valueOf("1000");
            System.out.println(b==c);

        }



    }



