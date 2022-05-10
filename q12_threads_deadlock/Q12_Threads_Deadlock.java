package q12_threads_deadlock;

public class Q12_Threads_Deadlock {
    public static void main(String[] args) {
        /*----------------------------------------

        //另外在一个锁里边，又重复的获取this锁，这种叫重入锁
        public void add(int m) {
            synchronized(lockA) { // 获得lockA的锁
                this.value += m;
                synchronized(lockB) { // 获得lockB的锁
                    this.another += m;
                } // 释放lockB的锁
            } // 释放lockA的锁
        }

        public void dec(int m) {
            synchronized(lockB) { // 获得lockB的锁
                this.another -= m;
                synchronized(lockA) { // 获得lockA的锁
                    this.value -= m;
                } // 释放lockA的锁
            } // 释放lockB的锁
        }

        在获取多个锁的时候，不同线程获取多个不同对象的锁可能导致死锁。
        对于上述代码，线程1和线程2如果分别执行add()和dec()方法时：
            线程1：进入add()，获得lockA；
            线程2：进入dec()，获得lockB。
        随后：
            线程1：准备获得lockB，失败，等待中；
            线程2：准备获得lockA，失败，等待中。

        那么我们如何避免死锁呢？
        答案：线程获取锁的顺序要一致。
        即严格按照先获取lockA，再获取lockB的顺序，
        可以改写洗dec方法
        public void dec(int m) {
            synchronized(lockA) { // 获得lockA的锁
                this.value -= m;
                synchronized(lockB) { // 获得lockB的锁
                    this.another -= m;
                } // 释放lockB的锁
            } // 释放lockA的锁
        }

        ---------------------------------------*/
        System.out.println("deadlock");

    }
}
