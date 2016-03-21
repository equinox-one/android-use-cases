package one.equinox.shaft;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ShaftExecutors {
    public static ShaftThreadPoolExecutor newFixedThreadPool(int nThreads) {
        return new ShaftThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
}
