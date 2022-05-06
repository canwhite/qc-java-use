package q11_threads_sync_update;

public class Q11_Threads_Sync_Update {
    public static void main(String[] args) {
        /*
            我们知道Java程序依靠synchronized对线程进行同步，
            使用synchronized的时候，锁住的是哪个对象非常重要。
            让线程自己选择锁对象往往会使得代码逻辑混乱，也不利于封装。
            更好的方法是把synchronized逻辑封装起来
         */

        //通过封装逻辑实现同步，就不需要多同步问题，然后可以创建多个对象，实现并发
        //Java也可以用var了
        var c1 = new Counter();
        var c2 = new Counter();

        //因为我们封装的是同步逻辑，针对逻辑开线程执行
        new Thread(()-> c1.add(10)).start();
        new Thread(()-> c1.dec(10)).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(c1.get());

        // 对c2进行操作的线程:
        new Thread(() -> c2.add(1)).start();
        new Thread(() -> c2.dec(2)).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(c2.get());
    }
}
class Counter{
    private  int count = 0;
    //做加法，写在synchronized,锁this
    public synchronized  void add(int n){
        count += n;
    }
    public synchronized  void dec(int n){
        count -= n;
    }
    public int get() {
        return count;
    }
}

/*-----------------------------------------------------
* PS:
*
PS:对于static方法，是没有this实例的，因为static方法是针对类而不是实例。
但是我们注意到任何一个类都有一个由JVM自动创建的Class实例，
因此，对static方法添加synchronized，锁住的是该类的Class实例

public class Counter {
    public static void test(int n) {
        synchronized(Counter.class) {
            ...
        }
    }
}
* -------------------------------------------------------*/


