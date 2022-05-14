package q17_threads_concurrent;

/* -----------------------------------------------------------

interface	non-thread-safe	              thread-safe
List	    ArrayList	                  CopyOnWriteArrayList
Map	        HashMap	                      ConcurrentHashMap
Set	        HashSet / TreeSet	          CopyOnWriteArraySet
Queue	    ArrayDeque / LinkedList	      ArrayBlockingQueue / LinkedBlockingQueue
Deque	    ArrayDeque / LinkedList	      LinkedBlockingDeque

 ------------------------------------------------------------*/


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q17_Threads_Concurrent {
    public static void main(String[] args) {
        /***************************************************
            之前我们使用reentrantLock和condition实现了BlockingQueue
            所谓的BlockingQueue的意思是说
            当一个线程调用这个TaskQueue的getTask()方法时，
            该方法内部可能会让线程变成等待状态，
            直到队列条件满足不为空，线程被唤醒后，getTask()方法才会返回。
             因为BlockingQueue非常有用，所以我们不必自己编写，
             可以直接使用Java标准库的java.util.concurrent包提供的线程安全的集合：
             ArrayBlockingQueue。
             出了ArrayBlockingQueue之外，还有其他类型的如上
         ***************************************************/

        Map<String, String> map = new ConcurrentHashMap<>();
        //在不同的线程中读写
        map.put("A","1");
        map.put("B","2");
        map.put("C","3");

        //循环输出
        for(Map.Entry<String,String> entry : map.entrySet()){
            //获取key和value
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }


        //同样我们要多使用CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();
        //在不同的线程中读写
        list.add("1");
        list.add("2");
        list.add("3");
        for (String str:list) {
            System.out.println(str);
        }

    }
}

