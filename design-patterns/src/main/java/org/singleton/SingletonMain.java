package org.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Runnable r = () -> System.out.println(Singleton.getInstance() + " " + Thread.currentThread());

        for(int i = 0; i < 100; i++)
            es.submit(r);

        es.shutdown();
    }
}

final class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null)
                instance = new Singleton();
        }
        return instance;
    }
}
