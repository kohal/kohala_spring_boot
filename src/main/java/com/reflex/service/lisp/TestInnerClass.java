package com.reflex.service.lisp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xuyongjian on 2017/3/19.
 */
public class TestInnerClass {

    public static void main(String[] args) {
        OutClass outClass=new OutClass();
//        OutClass.InnerClass innerClass=outClass.new InnerClass(3);
        System.out.println("OutClass.a:"+OutClass.a);
        System.out.println("OutClass.innerClass:"+OutClass.innerClass);
//        Field[] fields = new OutClass().getInnerClass().getClass().getFields();
//        for (Field field : fields
//                ) {
//            System.out.println(field.getName());
//
//        }
    }
}

class OutClass {
    public static InnerClass innerClass;
    public static int a ;

    static {
        System.out.println("OutClass  load");
    }


    public InnerClass getInnerClass() {
        return new InnerClass(3);
    }

    public class InnerClass {
        public int innerParam = 2;

        public void innerMethod() {
            Method[] methods = innerClass.getClass().getMethods();
            for (Method method :
                    methods) {
                System.out.println(method.getName());

            }
            Field[] fields = innerClass.getClass().getFields();
            for (Field field : fields
                    ) {
                System.out.println(field.getName());

            }
        }
        private InnerClass(){
            System.out.println("init InnerClass");
        }
        public InnerClass(int a) {
            System.out.println("init InnerClass+a"+a);
            OutClass.this.innerClass = new InnerClass();
        }
    }

//   public static void main(String[] args) {
        /*Field[] fields =InnerClass.class.getFields();
        for (Field field:fields
                ) {
            System.out.println(field.getName());

        }*/
//        System.out.println(OutClass.innerClass);
        /*OutClass outClass=new OutClass();
        innerClass=outClass.new InnerClass();
        innerClass.innerMethod();
        new OutClass().new InnerClass();*/
//    }
}


