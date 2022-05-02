//class的顶部应该就是Object
public class Q5_Class {
    public static void main(String[] args) {
        Person p1 = new Person("xiao ming",20);
        System.out.println(p1.getAge());
        System.out.println(p1.getName());
    }
}
/* ---------------------------------------------------------------------------
修饰符:
public : 对所有类可见。使用对象：类、接口、变量、方法
private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。 
-----------------------------------------------------------------------------*/
class Person {
    private String name;
    private int age;

    public Person() {
    }
    //可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分：
    //实际上这种方法名相同，但是参数不同这种叫做方法的重载
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}


//我们再写student，有些方法就不用重写
