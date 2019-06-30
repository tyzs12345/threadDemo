package com.tiany.stopThread.demo;

import javax.management.timer.TimerMBean;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 使用volatile的方式结束线程(其实是使线程正常结束)
 */
public class demo1 {

    public  static void main(String [] args) throws Exception{

        Mytask mytask = new Mytask();
        mytask.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("手动 end working---------------");
        mytask.close();

    }


    static class Mytask extends Thread
    {
        private volatile boolean closed = false;

        @Override
        public void run()
        {
            System.out.println("start working---------------");
            while (!closed && !isInterrupted()){
                System.out.println("working on --------------------");

            }
            System.out.println("end working---------------");
        }


        public void close()
        {
            this.closed = true;
            this.interrupt();
        }
    }

    public static Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName))
                return t;
        }
        return null;
    }

}
