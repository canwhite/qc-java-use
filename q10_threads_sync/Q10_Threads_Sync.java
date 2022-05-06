package q10_threads_sync;

public class Q10_Threads_Sync {
    public static void main(String[] args) {
        /*
            同步的本质就是给指定对象加锁，加锁后才能继续执行后续代码；
            注意加锁对象必须是同一个实例；
            对JVM定义的单个原子操作不需要同步。
                //不需要加锁的几种情况
                基本类型（long和double除外）赋值，例如：int n = m；
                引用类型赋值，例如：List<String> list = anotherList
                            如果是多行赋值语句，就必须保证是同步操作
                            因为不能保证同时compare
                //总结：需要同步的，long和double，以及多行赋值
         */
        //这里简单的创建了一个thread数组
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        try {
            add.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            dec.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Counter.count);

    }
}
//统一的绑定对象
class Counter {
    //如果是一组事件，需要锁同一个对象
    public static final Object lock = new Object();
    public static int count = 0;
}


class AddThread extends Thread {
    public void run() {
        for (int i=0; i<100; i++) {
            synchronized(Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class  DecThread extends  Thread{
    @Override //本质上写与不写jvm自己可以识别,都算作重写
    public  void run(){
        for(int i = 0; i<100;i++){
            synchronized (Counter.lock){
                Counter.count -=1;
            }
        }
    }
}


















