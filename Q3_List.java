//List在这里主要是作为类型存在
//ArrayList是具体的实现实例
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Q3_List {
    public static void main(String[] args) {
        /* ----------------------------------------------------
        什么是集合（Collection）？
        集合就是“由若干个确定的元素所构成的整体”

        Java标准库自带的java.util包提供了集合类：Collection，
        它是除Map外所有其他集合类的根接口。
        Java的java.util包主要提供了以下三种类型的集合：
        List：一种有序列表的集合，例如，按索引排列的Student的List；
        Set：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
        Map：一种通过键值（key-value）查找的映射表集合，
        例如，根据Student的name查找对应Student的Map。 

        Collection 接口是 List、Set 、Queue 接口的父接口，通常情况下不被直接使用 

        在集合类中，List是最基础的一种集合：它是一种有序列表。

        List的行为和数组几乎完全相同：List内部按照放入元素的先后顺序存放，
        每个元素都可以通过索引确定自己的位置，List的索引和数组一样，从0开始。

        ----------------------------------------------------*/

        //0.将数组转换为list
        String[] strArr = {
            "123",
            "456",
            "789"
        };
        
        //先定义个list，然后将Arr转化为list
        List<String> list = new ArrayList<String>();
        //使用asList转化
        list = Arrays.asList(strArr);
        System.out.println(list.toString());



        //1，基础使用
        //实现List接口并非只能通过数组（即ArrayList的实现方式）来实现，
        //另一种LinkedList通过“链表”也实现了List接口。
        List<String> list1 = new ArrayList<>();
        list1.add("apple"); // size=1
        list1.add("pear"); // size=2
        list1.add("apple"); // 允许重复添加元素，size=3
        System.out.println(list1.toString());
        

        //2.长度的获取
        System.out.println(list1.size());


        //3.移除某个位置上的数据
        //可以移除某个元素和移除某个索引的元素
        list1.remove("pear");
        System.out.println(list1.size());


        

        //4.of方法创建List,of()方法返回的是一个只读list
        List<String> list2 = List.of("apple", "pear", "banana");
        // list2.add("xxx");//添加会报错
        System.out.println("list2" + list2); 


        //5.contains,这个包含关系在处理对象数组的时候会非常有用
        System.out.println(list2.contains("apple"));

        //6.遍历
        //(1)普通
        for(int i =0; i<list2.size();i++){
            String item = list2.get(i);
            System.out.println(item);
        }

        //(2)遍历器
        for(Iterator<String> it = list2.iterator(); it.hasNext();){
            String s = it.next();
            System.out.println(s);
        }

        //(3)转成ArrayList再处理
        //Iterable接口的集合类都可以直接用for each循环来遍历
        for(String s : list2){
            System.out.println("item: "+s);
        }

        //7.asList和toArray();
        //第一种 ，Object[],基本就和any[]一个样子了,这种方法会丢失信息
        Object[] array = list2.toArray();
        System.out.println(array.toString());
        for (Object s : array) {
            System.out.println(s);
        }

        //第二种方式是给toArray(T[])传入一个类型相同的Array，
        //List内部自动把元素复制到传入的Array中：
        List<Integer> list3 = List.of(12,34,56);
        //这里长度正好
        Integer[] arr = list3.toArray(new Integer[list3.size()]);
        for(Integer n : arr){
            System.out.println(n);
        }
        //方法的泛型参数<T>并不是List接口定义的泛型参数<E>，
        //所以，我们实际上可以传入其他类型的数组，
        //例如我们传入Number类型的数组，返回的仍然是Number类型
        //但是如果传入类型不匹配的数组会报错



    }
}
