package q15_threads_readWriteLock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Q15_Threads_ReadWriteLock {
    public static void main(String[] args) {
        /*
            ReentrantLock保证了只有一个线程可以执行临界区代码
            但是有些时候，这种保护有点过头。
            比如读写操作：
                *只允许一个线程写入（其他线程既不能写入也不能读取）；
                *没有写入时，多个线程允许同时读（提高性能）。
            这时候使用ReadWriteLock实现这个功能十分容易
         */
        Counter counter = new Counter();
        counter.inc(1);
        System.out.println(counter.get());

    }
}
class Counter{
    //分成写锁和读锁
    private  final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private  final Lock rlock = rwlock.readLock();
    private  final Lock wlock = rwlock.writeLock();
    private  int[] counts = new int[10];

    //写操作
    public void  inc(int index){
        wlock.lock();//加写锁
        try {
            counts[index] +=1;
        }finally {
            wlock.unlock();
        }

    }

    //读操作
    public  int[] get(){
        //加读锁
        rlock.lock();
        try{
            //复制返回，copyOf方法
            return Arrays.copyOf(counts,counts.length);
        }finally {
            rlock.unlock();
        }
    }
}


