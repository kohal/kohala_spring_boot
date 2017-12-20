package com.reflex.util;

import java.util.concurrent.*;

/**
 * 可伸缩性的缓存
 *
 * @author: xuyongjian
 * @date: 2017/11/26
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A a) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(a);
            if (f == null) {
                Callable<V> eval = () -> c.compute(a);
                FutureTask<V> ft = new FutureTask(eval);
                f = cache.putIfAbsent(a, ft);
                if (f == null) {
                    f = ft;
                    ft.run();

                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(a, f);
            } catch (ExecutionException e) {
                throw new RuntimeException(e.getMessage());
            }

        }


    }
}

