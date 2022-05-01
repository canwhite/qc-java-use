import java.util.HashMap;
import java.util.Map;

public class Q4_Map {
    public static void main(String[] args) {
        //pre，通过name查询某个学生的分数
        //先创建一个学生
        Student s = new Student("Xiao Ming", 99);
        //创建一个map对象，key是String，value是我们的Student
        //这里Map和List一样都是作为类型存在，而真正实例化的是HashMap
        Map<String,Student> map = new HashMap<>();
        //将key和value实例，映射关联
        map.put("Xiao Ming" ,s);
        //通过key查找并返回映射的Student实例
        Student target = map.get("Xiao Ming");
        System.out.println(target);
        System.out.println(target == s); // true，同一个实例
        //然后获取分数
        System.out.println(target.score); // 99


        //1.update
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("pear", 123);
        map1.put("apple", 123);
        map1.put("apple", 456);

        System.out.println(map1.get("apple"));
        

        //遍历map
        //keySet()方法返回的Set集合，它包含不重复的key的集合




        

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
}