package q8_threads;
public class Q8_Threads {
    public static void main(String[] args) {
        //Java语言内置了多线程支持。当Java程序启动的时候，实际上是启动了一个JVM进程，
        //然后，JVM启动主线程来执行main()方法。在main()方法中，我们又可以启动其他线程。

        //新建一个Thread实例，然后调用它的start方法 
        Thread t = new Thread();
        t.start(); 
        //但是这样什么也没做就立刻结束了
        //我们希望在线程中做些事情，这时候就需要一些其他方法


        //(1)方法一：从Thread派生一个自定义类，然后覆写run()方法

        Thread mt = new MyThread();
        mt.start(); // 启动新线程--只有调用start方法才能执行新线程，单独执行run并没有效果


        //(2)方法二：创建Thread实例时，传入Runnable实例：
        Thread tr = new Thread(new MyRunnable());
        tr.start(); // 启动新线程


        //(3)lambda语法进一步简写
        Thread tl = new Thread(()->{
            //这里边相当于run
            System.out.println("start new thread ->");
        });
        tl.start();
        //上边的方法等价于
        System.out.println("main start...");
        //可以作为一个类来实现
        Thread tc = new Thread() {
            public void run() {
                System.out.println("thread run...");
                System.out.println("thread end.");
            }
        };
        tc.start();
        //一个线程可以等待另外一个线程结束之后再执行，比如main等待tc
        //调用join方法，也可以指定一个等待时间，超过等待时间就不再继续等待
        //tc.join();
        //(4)线程睡眠，sleep是个静态方法
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
        System.out.println("main end...");


        //(5)线程优先级，也是一个静态方法
        //Thread.setPriority(int n) // 1~10, 默认值5
        //优先级高的线程被操作系统调度的优先级较高，操作系统对高优先级线程可能调度更频繁，
        //但我们决不能通过设置优先级来确保高优先级的线程一定会先执行。


        //(6)线程状态图
        /*      ┌─────────────┐
                │     New     │
                └─────────────┘
                    │
                    ▼
        ┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐
        ┌─────────────┐ ┌─────────────┐
        ││  Runnable   │ │   Blocked   ││
        └─────────────┘ └─────────────┘
        │┌─────────────┐ ┌─────────────┐│
        │   Waiting   │ │Timed Waiting│
        │└─────────────┘ └─────────────┘│
        ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─
                    │
                    ▼
                ┌─────────────┐
                │ Terminated  │
                └─────────────┘
        timed waiting 是指我们调用sleep时候的情况，blocked是某些操作阻塞导致挂起
        */


        
    }
}

class MyThread extends Thread{
    //重写run方法，做自己的事情
    @Override
    public void run(){
        System.out.println("start new thread m");
    }
}

//方法二，继承runnable接口，重写run方法
class MyRunnable implements Runnable{
    //还是重写run方法
    @Override
    public void run(){
        System.out.println("start new thread r");
    }

} 
