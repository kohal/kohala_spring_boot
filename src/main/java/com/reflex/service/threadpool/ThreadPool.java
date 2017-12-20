package com.reflex.service.threadpool;

/**
 * @author: xuyongjian
 * @date: 2017/12/10
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();
}
