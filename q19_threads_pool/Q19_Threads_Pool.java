package q19_threads_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q19_Threads_Pool {
    public static void main(String[] args) {
        /**************
            线程池内部维护了若干个线程，没有任务的时候，这些线程都处于等待状态。
            如果有新任务，就分配一个空闲线程执行。如果所有线程都处于忙碌状态，
            新任务要么放入队列等待，要么增加一个新线程进行处理。

            Java标准库提供了ExecutorService接口表示线程池
         -----
         因为ExecutorService只是接口，Java标准库提供的几个常用实现类有：
             FixedThreadPool：线程数固定的线程池；
             CachedThreadPool：线程数根据任务动态调整的线程池；
             SingleThreadExecutor：仅单线程执行的线程池。
         *************/
        ExecutorService es = Executors.newCachedThreadPool();
        /*
            也可以创建动态范围的线程池
            int min = 4;
            int max = 10;
            ExecutorService es = new ThreadPoolExecutor(min, max,
                    60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

         */
        for(int i =0; i<6;i++){
            //添加线程用submit
            es.submit(new Task(""+i));
        }
        //关闭线程池
        es.shutdown();

        /*
            PS : 还有一种任务，需要定期反复执行，例如，每秒刷新证券价格。
            可以使用ScheduledThreadPool

            ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
            // 1秒后执行一次性任务:
            ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
            // 2秒后开始执行定时任务，每3秒执行:
            ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
            // 如果任务以固定的3秒为间隔执行，我们可以这样写：
            ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);

            * FixedRate这三秒包含任务执行时间
            * FixedDelay这三秒是任务之间的间隔
         */
    }
}
//固定大小的线程池的使用
class Task implements  Runnable{
    private  final  String name;
    public  Task(String name){
        this.name = name;
    }

    @Override
    public  void  run(){
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        System.out.println("start end " + name);
    }
}




