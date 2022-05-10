package q14_threads_reentrantLock_condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q14_Threads_ReentrantLock_Condition {
    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();
        queue.addTask("123");
        String top =  queue.getTask();
        System.out.println(top);
    }
}

class  TaskQueue{
    //这里从concureent引出一个Lock类型
    private  final Lock lock = new ReentrantLock();
    //从lock引出一个condition
    private  final Condition condition = lock.newCondition();
    //然后创建一个队列
    Queue<String> queue = new LinkedList<>();

    public void  addTask(String s){
        lock.lock();
        try{
            queue.add(s);
            //condition里边有wait和signal
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public  String getTask(){
        lock.lock();
        try{
            while (queue.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            return  queue.remove();
        }finally {
            lock.unlock();
        }
    }
}
