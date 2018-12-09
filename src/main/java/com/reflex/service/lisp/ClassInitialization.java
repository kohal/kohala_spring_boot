package com.reflex.service.lisp;

import java.util.Random;

/**
 * Created by xuyongjian on 2016/12/17.
 */
class Initable{
    static final int staticfinal=47;
    static final int staticfinal2=ClassInitialization.random.nextInt(1000);
    static{
        System.out.println("Initialzation Initable");
    }
}

class Initable2{
    static  int staticnotfinal=147;
    static{
        System.out.println("Initialzation Initable2");
    }
}

class Initable3{
    static final int staticfinal=247;
    static{
        System.out.println("Initialzation Initable3");
    }
}

public class ClassInitialization {
    public static Random random=new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable=Initable.class;
        System.out.println("after Creating Initable ref");
        System.out.println(Initable.staticfinal);
        System.out.println(Initable.staticfinal2);
        System.out.println(Initable2.staticnotfinal);
        Class initable3=Class.forName("Initable3");
        System.out.println("after Creating Initable3 ref");
        System.out.println(Initable3.staticfinal);

    }
}
