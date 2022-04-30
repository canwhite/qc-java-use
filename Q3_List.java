//List在这里主要是作为类型存在
//ArrayList是具体的实现实例
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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






    }
}
