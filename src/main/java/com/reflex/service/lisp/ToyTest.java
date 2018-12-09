package com.reflex.service.lisp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface HasBatteries{};

interface Waterproof{};

interface Shootd{};

class Toy{
    int i;
    public Toy(){
        System.out.println("newinstance"+this);
    };
    public Toy(int i){
        this.i=i;
        System.out.println("newinstance"+this+i);
    };

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}

class FancyToy extends Toy{
    FancyToy(){
        super(1);
    };
}

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name:  "+cc.getName()+"  is Interface?;" +cc.isInterface());
        System.out.println("Simple name:"+cc.getSimpleName());
        System.out.println("Canonical name:"+cc.getCanonicalName());
        System.out.println("Methods"+cc.getMethods());
    }
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException {
        Class c=null;
        c = FancyToy.class;
        printInfo(c);
        Class up = c.getSuperclass();
        printInfo(up);
        try {
            Object obj = up.newInstance();


            Constructor constructor = up.getConstructor(int.class);
            Object obj1 = constructor.newInstance(4);


            System.out.println(up.isInstance(obj));
            System.out.println("obj:=" + obj);
            System.out.println("obj1:=" + obj1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Hello World!");
    }
}
