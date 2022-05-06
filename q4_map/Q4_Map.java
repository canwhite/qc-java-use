package  q4_map;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q4_Map {
    public static void main(String[] args) {

        //1.update
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("pear", 123);
        map1.put("apple", 123);
        map1.put("apple", 456);
        map1.put("banana", 789);

        System.out.println(map1.get("apple"));
        

        //2.遍历map
        //keySet()方法返回的Set集合，它包含不重复的key的集合
        //(1)通过遍历key获取value
        for (String key : map1.keySet()) {
            Integer value = map1.get(key);
            System.out.println(key + " = " + value);
        }

        //(2)entry
        //entrySet
        for (Map.Entry<String,Integer> entry : map1.entrySet()){
            String key = entry.getKey();//从entry里getKey
            Integer value = entry.getValue();//从entry里getValue
            System.out.println(key + " = " + value);
        }


        //4.key:对象
        //先创建一个学生
        Student s = new Student("Xiao Ming", 99);
        //创建一个map对象，key是String，value是我们的Student
        //这里Map和List一样都是作为类型存在，而真正实例化的是HashMap
        Map<String,Student> map2 = new HashMap<>();
        //将key和value实例，映射关联
        String key = "Xiao Ming";
        map2.put(key ,s);
        //通过key查找并返回映射的Student实例
        Student target = map2.get(key);
        System.out.println(target);
        System.out.println(target == s); // true，同一个实例
        //然后获取分数
        System.out.println(target.score); // 99



        //3.equils 和hashCode
        //因为在Map的内部，对key做比较是通过equals()实现的，
        //这一点和List查找元素需要正确覆写equals()是一样的，
        //即正确使用Map必须保证：作为key的对象必须正确覆写equals()方法。

        String key1 = "a";
        Map<String, Integer> map3 = new HashMap<>();
        map3.put(key1, 123);

        String key2 = new String("a");
        map3.get(key2); // 123


        System.out.println(key1 == key2); // false
        System.out.println(key1.equals(key2)); // true
        System.out.println(key1.hashCode() + "?=" + key2.hashCode());

        /*
        总结：
        既然HashMap内部使用了数组，通过计算key的hashCode()直接定位value所在的索引，
        那么第一个问题来了：hashCode()返回的int范围高达±21亿，先不考虑负数，HashMap内部使用的数组得有多大？

        实际上HashMap初始化时默认的数组大小只有16，任何key，无论它的hashCode()有多大，都可以简单地通过：
        int index = key.hashCode() & 0xf; // 0xf =15
        把索引确定在0～15，即永远不会超出数组范围，上述算法只是一种最简单的实现

        一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
        如果equals()返回true，则hashCode()返回值必须相等；
        如果equals()返回false，则hashCode()返回值尽量不要相等。
        实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。 

        */

        

    }
}
//实现一个Student的类
class Student {
    public String name;
    public int score;
    //书写一下构造函数
    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }


    //实现equils方法
    public boolean equals(Object o){
        //instanceof作用到构造函数
        if (o instanceof Student) {
            Student s = (Student) o;
            //String是引用类型，用equals确定，基本类型用==操作
            return Objects.equals(this.name, s.name) && this.score == s.score;
        }
        return false;
    }

    //equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；
    //equals()中没有使用到的字段，绝不可放在hashCode()中计算。
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.score);
    }
}
