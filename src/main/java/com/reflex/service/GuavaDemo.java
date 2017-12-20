package com.reflex.service;

import com.google.common.base.*;
import com.google.common.collect.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/6/28
 */
public class GuavaDemo {

    public static void main(String[] args) {

        Integer a=null;
        Optional<Integer> op=Optional.of(new Integer(10));

        Optional.empty();

        Preconditions.checkNotNull(op);

        Preconditions.checkArgument(op.get()==10,"%s",op);



        //joiner and splitter
        String joiner=Joiner.on("|").useForNull("null").join("1", "2", null,"3");

        System.out.println(joiner);

        Iterable<String> iterable=Splitter.onPattern("\\s+").split("12 \t13 \n  \r\n   14");
        System.out.println(iterable);

        Objects.equal(op, a);

        MoreObjects.toStringHelper(op);

        List list=Lists.newArrayList("h", "o","l");

        //不可变集合
        ImmutableList.copyOf(list);
        ImmutableMap  map= ImmutableMap.of("T", 1, "R", 2);
        System.out.println(map.get("R"));

        //可重复集合
        ArrayListMultimap multimap =ArrayListMultimap.create();
        multimap.put("k", 1);
        multimap.get("k");

        Sets.newHashSet().add("k");

//        Ordering

        System.out.println(Objects.equal(null,null));

        System.out.println(MoreObjects.toStringHelper(op));

        Map map1 = Maps.toMap(list, new Function<Object, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable Object input) {
                return input.hashCode();
            }
        });
        System.out.println(map1);


    }
}

//// Class is typically registered by the container.
//class EventBusChangeRecorder {
//    @Subscribe
//    public void recordCustomerChange(ChangeEvent e) {
//        recordChange(e.getChange());
//    }
//}
//// somewhere during initialization
//eventBus.register(new EventBusChangeRecorder());
//// much later
//public void changeCustomer() {
//        ChangeEvent event = getChangeEvent();
//        eventBus.post(event);
//        }
