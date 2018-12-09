package com.reflex.service.lisp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xuyongjian on 2016/12/18.
 */

interface FactoryInter<T>{
    T create();
}

class Part{
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<FactoryInter<? extends Part>> partFactories=new ArrayList<FactoryInter<? extends Part>>();

    static {partFactories.add(new FuelFilter.Factory());
    partFactories.add(new AirFilter.Factory());
    partFactories.add(new FuelBelt.Factory());}

    private static Random rand=new Random(47);
    public static Part createRandom(){
        int n=rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

}

class Filter extends Part{}

class FuelFilter extends Filter{
    public static class Factory implements FactoryInter<FuelFilter>{
        public FuelFilter create(){
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter{
    public static class Factory implements FactoryInter<AirFilter>{
        public AirFilter create(){
            return new AirFilter();
        }
    }
}


class Belt extends Part{}

class FuelBelt extends Belt{
    public static class Factory implements FactoryInter<FuelBelt>{
        public FuelBelt create(){
            return new FuelBelt();
        }
    }
}

public class RegisteredFactiries {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
