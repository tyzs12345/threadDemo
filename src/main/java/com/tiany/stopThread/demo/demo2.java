package com.tiany.stopThread.demo;

import java.util.concurrent.TimeUnit;

public class demo2 {

    public  static void main(String [] args) throws Exception{

        MyThread myThread = new MyThread();
        myThread.start();
        TimeUnit.SECONDS.sleep(2);
        myThread.interrupt();

    }

   /*static class MyThread extends Thread
   {
       @Override
       public void run()
       {
           System.out.println("线程状态: "+isInterrupted());
           System.out.println("is working------------------");
           try {
               TimeUnit.SECONDS.sleep(4); //可中断方法会捕获到中断信号并且擦除interrupt标识。目的是为了让
               //线程的里其他方法执行
           } catch (InterruptedException e) {
               e.printStackTrace();
               return; //结束掉当前线程
           }

           System.out.println("------------------------------------------");
           System.out.println("线程状态: "+isInterrupted());

       }
   }
*/
    static class MyThread extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("线程状态: "+isInterrupted());
            System.out.println("start working------------------");
            while (true)
            {
                System.out.println("is working------------------");
                System.out.println("isInterrupted------------------"+ isInterrupted());
                if(isInterrupted())
                {
                   break;
                }

            }

        }
    };


}
