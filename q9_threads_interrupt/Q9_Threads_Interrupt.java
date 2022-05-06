package q9_threads_interrupt;

public class Q9_Threads_Interrupt {
    public static void main(String[] args) {
        //两种interrupt的方式
        //(1)调用interrupt
        /*
        a. isInterrupted 判断非中断再执行，
            需要使用while判断，以便一直处于判断状态
        b. 如果线程处于等待状态，此时如果对该线程调用interrupt,
            join()方法会立刻抛出InterruptedException,可以使用try ... catch监听方法，
        c. 如果在线程中还调用了其他线程，这时候要链式中断，结束子thread
         */

        Thread t = new MyThread();
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //中段线程，需要在内部链式中断
        t.interrupt();
        //这些有可能被中断的方法记得加catch
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");


        //(2)可变状态判断
        /*
        因此，volatile关键字的目的是告诉虚拟机：
            每次访问变量时，总是获取主内存的最新值；
            每次修改变量后，立刻回写到主内存。
         */
        StateThead s = new StateThead();
        s.start();
        try {
            //给点时间让sleep一会儿
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //更改 valatile的意思就是不稳定
        s.running = false;


        //总结：个人感觉第二种更方便



    }
}

//方法一
class MyThread extends  Thread{
    public void run(){
        Thread hello = new HelloThread();
        hello.start(); //启动hello线程
        try {
            //如果等待
            hello.join();
        }catch(InterruptedException e) {
            System.out.println("interrupted!");
        }
        //结束子thread
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        //(1)结束了子thred，下边action就不会在jvm执行了
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

//方法二
class  StateThead extends  Thread{
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " state!");
        }
        System.out.println("end!");
    }
}