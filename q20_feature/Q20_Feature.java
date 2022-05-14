package q20_feature;
import java.util.concurrent.*;

public class Q20_Feature {
    public static void main(String[] args) {
        /*
            Feature类似Promise，解决了Runnable提供返回值困难的问题，并且可以获取异步结果

            一般需要设置变量和提供额外方法提取，非常不便
            所以，Java标准库还提供了一个Callable接口，和Runnable接口比，它多了一个返回值：
            class Task implements Callable<String> {
                public String call() throws Exception {
                    return longTimeCalculation();
                }
            }
            并且Callable接口是一个泛型接口，可以返回指定类型的结果。

            一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：
                get()：获取结果（可能会等待）
                get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
                cancel(boolean mayInterruptIfRunning)：取消当前任务；
                isDone()：判断任务是否已完成。
         */


        ExecutorService executor = Executors.newFixedThreadPool(4);
        //（1） 定义任务,实现Callable的call方法
        Callable<String> task = new Task();
        // (2) 提交任务并获得Future:
        // 只是用Feature去接Callable的异步返回值
        Future<String> future = executor.submit(task);
        // 从Future获取异步执行返回的结果:
        try {
            //(3)通过get获取result
            String result = future.get(); // 可能阻塞
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//将请求任务放在这里
class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "456";
    }
}
