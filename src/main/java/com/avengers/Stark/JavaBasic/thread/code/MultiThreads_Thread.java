package com.avengers.Stark.JavaBasic.thread.code;

import java.util.concurrent.Semaphore;

public class MultiThreads_Thread extends Thread {

    private Semaphore semaphore;
    private String threadName;
    private String series;

    private MultiThreads_Thread(Semaphore semaphore, String threadName, String series) {
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.series = series;
    }

    public static void main(String[] args) {
        String series = "010203040506";
        Semaphore sem = new Semaphore(1);
        MultiThreads_Thread t1 = new MultiThreads_Thread(sem, "1", series);
        MultiThreads_Thread t2 = new MultiThreads_Thread(sem, "2", series);
        MultiThreads_Thread t3 = new MultiThreads_Thread(sem, "3", series);
        t1.start();
        t2.start();
        t3.start();
    }

    public void run() {
        try {
            semaphore.acquire();
            StringBuilder sb = new StringBuilder();
            switch (threadName) {
                case "1":
                    System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
                    for (int i = 0; i < this.series.length(); i++) {
                        int cur = Integer.parseInt(this.series.charAt(i) + "");
                        if (cur == 0) {
                            sb.append(cur);
                        }
                    }
                    System.out.println("[thread]" + threadName + ":" + sb.toString());
                    break;
                case "2":
                    System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
                    for (int i = 0; i < this.series.length(); i++) {
                        int cur = Integer.parseInt(this.series.charAt(i) + "");
                        if (cur % 2 == 0 && cur != 0) {
                            sb.append(cur);
                        }
                    }
                    System.out.println("[thread]" + threadName + ":" + sb.toString());
                    break;
                case "3":
                    System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
                    for (int i = 0; i < this.series.length(); i++) {
                        int cur = Integer.parseInt(this.series.charAt(i) + "");
                        if (cur % 2 != 0) {
                            sb.append(cur);
                        }
                    }
                    System.out.println("[thread]" + threadName + ":" + sb.toString());
                    break;
            }
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
