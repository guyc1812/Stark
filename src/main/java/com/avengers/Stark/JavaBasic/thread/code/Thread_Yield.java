package com.avengers.Stark.JavaBasic.thread.code;

public class Thread_Yield {

    private static Object obj = new Object();

    public static void main(String[] args) {
        YieldThread t1 = new YieldThread("t1");
        YieldThread t2 = new YieldThread("t2");
        t1.start();
        t2.start();
    }

    static class YieldThread extends Thread {
        YieldThread(String name) {
            super(name);
        }

        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 6; i++) {
                    System.out.println(this.getName() + " is running");
                    if (i % 2 == 0)
                        System.out.println(this.getName() + " is yielding");
                    Thread.yield();
                }
            }
        }
    }

}
