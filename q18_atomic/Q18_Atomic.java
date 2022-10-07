package q18_atomic;

import java.util.concurrent.atomic.AtomicInteger;
// import java.util.concurrent.atomic.AtomicLong;

public class Q18_Atomic {
    public static void main(String[] args) {
        /*********************
        Atomic类是通过无锁（lock-free）的方式实现的线程安全（thread-safe）访问。
        它的主要原理是利用了CAS：Compare and Set。
        实际上通过Compare and Set也能大致明白它的原理
        简称CAS

        原子操作实现了无锁的线程安全；
        适用于计数器，累加器等。
        **********************/
        IdGenerator gen = new IdGenerator();
        System.out.println(gen.getNextId());



    }

}

//用CAS做一个简单的id生成器
class IdGenerator {
    AtomicInteger var = new AtomicInteger(0);
    public long getNextId() {
        return var.incrementAndGet();
    }
    //如果我们自己通过CAS编写incrementAndGet()，它大概长这样：
    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( ! var.compareAndSet(prev, next));
        //总结：
        //! var.compareAndSet(prev, next)
        //如果当前值不变，compareAndSet返回为true,!true为false，不做操作
        //如果当前值变化，compareAndSet返回为false，!false为true，做更新操作
        return next;
    }
}



