package q16_threads_stamptedLock;

import java.util.concurrent.locks.StampedLock;

public class Q16_Threads_StamptedLock {
    public static void main(String[] args) {
        /* -------------------------------------------------------------
        ReadWriteLock 的问题：
        如果有线程正在读，写线程需要等待读线程释放锁后才能获取写锁，即读的过程中不允许写，
        这是一种悲观的读锁
        StampedLock和ReadWriteLock相比优势：
        读的过程中也允许获取写锁后写入！这样一来，我们读的数据就可能不一致，
        所以，需要一点额外的代码来判断读的过程中是否有写入，这种读锁是一种乐观锁。
        ----------------
            悲观锁和乐观锁
            乐观锁的意思就是乐观地估计读的过程中大概率不会有写入，因此被称为乐观锁。
            反过来，悲观锁则是读的过程中拒绝有写入，也就是写入必须等待。
            显然乐观锁的并发效率更高
            但一旦有小概率的写入导致读取的数据不一致，需要能检测出来，再读一遍就行
         --------------------------------------------------------------*/

        //point
        Point point = new Point();
        point.move(2,3);
        System.out.println(point.distanceFromOrigin());

    }
}
class Point{

    private  final StampedLock  stampedLock = new StampedLock();
    private  double x;
    private  double y;

    //写锁还是跟之前的写锁一样
    public void move(double deltaX, double deltaY){
        //返回版本号方便在finally里结束锁
        //下边还可以通过版本号监测写入变更
        // 无论是读锁还是写锁都可以从stampedLock中取
        long stamp = stampedLock.writeLock();//获取写锁
        try {
            x+= deltaX;
            y+= deltaY;
        }finally {
            //释放写锁
            stampedLock.unlockWrite(stamp);
        }
    }

    public  double distanceFromOrigin(){
        //乐观锁
        long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁
        //注意下边两行代码不是原子操作
        double currentX = x;
        double currnetY = y;

        //如果检测到写锁发生，重新用悲观读锁读取
        //如果vilidate返回false，说明有变动
        if (!stampedLock.validate(stamp)){
            stamp = stampedLock.readLock(); // 获取一个悲观读锁
            try{
                currentX = x;
                currnetY = y;
            }finally {
                stampedLock.unlockRead(stamp);
            }
        }
        //做返回
        return Math.sqrt(currentX * currentX + currnetY * currnetY);
    }

}








