package com.reflex.service.lisp;

/**
 * @Author: xuyongjian
 * @Date: 2017/8/30
 */
public enum EnumTest {

    TEST1("test");

    String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    EnumTest(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "EnumTest{" +
                "des='" + des + '\'' +
                '}';
    }
}
