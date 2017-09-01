package com.reflex.service;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/7/11
 */
public class TestReflex {

    public static void main(String[] args) {

//        System.out.printf(Objects.equals(null, 1)+"");
//        Class<Reflex> reflexClass = Reflex.class;

//        for (Method method :
//                clasz.getMethods()) {
//            System.out.println(method.toGenericString());
//        }
//
//        Reflex test = new Reflex();
//        test.setA(3);
//        for (Field field :
//                reflexClass.getDeclaredFields()) {
//
//
//            if("a".equals(field.getName())){
//                try {
//                    field.set(test,2);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//        System.out.println(test.getA());


        String copy = "选择： 基于 冲突 检测 的 乐观 并发 策略， 通俗 地说， 就是 先进 行 操作， 如果 没有 其他 线程 争用 共享 数据， 那 操作 就 成功 了； 如果 共享 数据 有 争用， 产生了 冲突， 那就 再 采取 其他 的 补偿措施（ 最 常见 的 补偿 措施 就是 不断 地 重试， 直到 成功 为止）， 这种 乐观 的 并发 策略 的 许多 实现 都不 需要 把 线程 挂起， 因此 这种 同步 操作 称为 非 阻塞 同步（ Non- Blocking Synchronization）。";


        System.out.println(copy.trim().replaceAll(" +",""));
    }
}
