

import java.util.Arrays;
import java.util.Collections;


public class Q2_Array {
    public static void main(String[] args) {

        //Pre: 
        //思路为先把array转化为list，用list的add()方法添加元素，再把list转化为array


        //1. 数组和遍历
        Integer[] ns = { 1, 4, 9, 16, 25 }; //注意数组字面量用的不是中括号

        // 首先直接打印数组类型，得到的是解释器中的引用地址
        System.out.println(ns); //[I@4926097b 
        // 我们可以使用java标准库中的方法去打印
        // 使用其提供的toString()
        System.out.println(Arrays.toString(ns));


        //常规for循环， 注意数组长度使用length拿到的
        for (int index=0; index<ns.length; index++) {
            int data = ns[index];
            System.out.println(data);
        }

        // forEach 中间是用 : 隔开的
        for (int item : ns) {
            System.out.println(item);
        }


        //2.数组和排序
        // Arrays.sort(ns);
        Arrays.sort(ns, Collections.reverseOrder());
        System.out.println(Arrays.toString(ns));


        //3.fill
        int a[] = new int[10];
        Arrays.fill(a, 5);
        System.out.println(Arrays.toString(a));


        //4.toString和equils来自顶层父类Object




        
    }


}
