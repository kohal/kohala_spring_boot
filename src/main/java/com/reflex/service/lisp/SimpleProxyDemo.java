package com.reflex.service.lisp;

/**
 * Created by xuyongjian on 2016/12/18.
 */

interface Interface{
    void dosometing();
    void dosomethingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void dosometing() {
        System.out.println("do something");
    }

    @Override
    public void dosomethingElse(String arg) {
        System.out.println("dosomthing Else"+arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void dosometing() {
        System.out.println("do something");
        proxied.dosometing();
    }

    @Override
    public void dosomethingElse(String arg) {
        System.out.println("dosomthing Else"+arg);
        proxied.dosomethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.dosometing();
        iface.dosomethingElse("proxy");
    }
    public static void main(String[] args) {
        consumer(new RealObject() );
        consumer(new SimpleProxy(new RealObject()));


    }
}
