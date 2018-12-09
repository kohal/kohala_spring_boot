package com.reflex.service.lisp;

import java.io.*;

/**
 * Created by xuyongjian on 2017/2/25.
 */
public class TestSerializable implements Serializable {

    public ReflexBean reflexBean=new ReflexBean("lyj","no1");

    private static final long serialVersionUID = 1L;

    public static int staticVar = 5;

    private int noStaticVar = 20;

    public int getNoStaticVar() {
        return noStaticVar;
    }

    public void setNoStaticVar(int noStaticVar) {
        this.noStaticVar = noStaticVar;
    }

    public TestSerializable(int noStaticVar) {
        this.noStaticVar = noStaticVar;
    }

    public static void main(String[] args) {
        try {
            //初始时staticVar为5·
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(EnumTest.TEST1);
            out.close();

            //序列化后修改为10
            TestSerializable.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            EnumTest t = (EnumTest) oin.readObject();
            oin.close();

            System.out.println(t);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

