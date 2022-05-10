package q13_threads_wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class Q13_Threads_Wait_Notify {
    public static void main(String[] args) {

        /*是synchronized并没有解决多线程协调的问题。
        wait/notify是为了解决协调问题*/

        TaskQueue queue = new TaskQueue();
        queue.addTask("123");
        String top =  queue.getTask();
        System.out.println(top);


    }
}
class  TaskQueue{
    //如果前边定义了，后边不需要在加T
    Queue<String> queue = new LinkedList<>();

    public  synchronized  void addTask(String s){
        this.queue.add(s);
        //this.notify(); // 唤醒在this锁等待的线程
        this.notifyAll();
    }
    /*实际上while()循环永远不会退出。因为线程在执行while()循环时，
    已经在getTask()入口获取了this锁，其他线程根本无法调用addTask()，
    因为addTask()执行条件也是获取this锁。
    这时候就需要wait，释放this锁了*/
    public  synchronized  String getTask(){
        while (queue.isEmpty()){
            try {
                //wait会释放this锁
                this.wait();
                //notify之后重新获取this锁
                //这时候queue里边有了元素，所以会继续往下走
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return  queue.remove();
    }
}
