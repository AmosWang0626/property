package cn.zut.common.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/11
 */
public class ThreadUtil {

    public static void main(String[] args) {
        for (int i = 0, len = 10; i < len; i++) {
            oldThread1();
            safeThread2();
            safeThread1();
        }
    }

    /**
     * 线程池不允许使用Executors去创建, 而是通过ThreadPoolExecutor的方式,
     * 这样的处理方式让写的同学更加明确线程池的运行规则, 规避资源耗尽的风险.
     * <p>
     * 说明：Executors各个方法的弊端：
     * 1）newFixedThreadPool和newSingleThreadExecutor:
     *   主要问题是堆积的请求处理队列可能会耗费非常大的内存, 甚至OOM.
     * 2）newCachedThreadPool和newScheduledThreadPool:
     *   主要问题是线程数最大数是Integer.MAX_VALUE, 可能会创建数量非常多的线程, 甚至OOM
     * <p>
     * <p>
     * Positive example 3：
     * <bean id="userThreadPool"
     * class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
     * <property name="corePoolSize"value="10"/>
     * <property name="maxPoolSize"value="100"/>
     * <property name="queueCapacity"value="2000"/>
     * <property name="threadFactory"value=threadFactory />
     * <property name="rejectedExecutionHandler">
     * <ref local="rejectedExecutionHandler"/>
     * </property>
     * </bean>
     * //in code
     * userThreadPool.execute(thread);
     */
    private static void oldThread1() {
        // Google 线程命名
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("danger-0-%d").build();
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        executorService.shutdown();
    }

    /**
     * corePoolSize: 核心线程数, 默认情况下核心线程会一直存活, 即使处于闲置状态也不会受存keepAliveTime限制.除非将allowCoreThreadTimeOut设置为true.
     * maximumPoolSize: 线程池所能容纳的最大线程数.超过这个数的线程将被阻塞.当任务队列为没有设置大小的LinkedBlockingDeque时, 这个值无效.
     * keepAliveTime: 非核心线程的闲置超时时间, 超过这个时间就会被回收.
     * unit: 指定keepAliveTime的单位, 如TimeUnit.SECONDS.当将allowCoreThreadTimeOut设置为true时对corePoolSize生效.
     * workQueue: 线程池中的任务队列.常用的有三种队列, SynchronousQueue, LinkedBlockingDeque, ArrayBlockingQueue.
     * threadFactory: 线程工厂, 提供创建新线程的功能.
     * handler: 当线程池中的资源已经全部使用, 添加新线程被拒绝时, 会调用RejectedExecutionHandler的rejectedExecution方法.
     */
    private static void safeThread1() {
        // Google 线程命名
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("safe-1-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.shutdown();
    }

    /**
     * 同上 --- 他们都是java.util.concurrent里的类
     * daemon: true-->守护线程;
     * 守护线程:
     * 1) 区别于常规用户线程,当线程只剩下守护线程的时候,JVM就会退出
     * 2) 当主线程结束时, 结束其余的子线程（守护线程）自动关闭, 就免去了还要继续关闭子线程的麻烦。
     * 3) 如：Java垃圾回收线程就是一个典型的守护线程；内存资源或者线程的管理, 但是非守护线程也可以。
     */
    private static void safeThread2() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,
                new BasicThreadFactory.Builder().namingPattern("safe-2-%d").daemon(true).build());
        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        executorService.shutdown();
    }
}
