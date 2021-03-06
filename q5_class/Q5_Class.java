
package  q5_class;
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


//1.实现继承
class Student  extends Person{
    protected int score;
    public Student(String name,int age , int score){
        super(name,age);//调用父类的构造方法
        //另外，从这里可以看出，类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的
        this.score = score;
    }
}


//2.阻止继承
/* ----------------------------------------------------------------------------
//sealed 封闭修饰符，然后permits指定哪些子类可以继承

//父类sealed限制
public sealed class Shape permits Rect, Circle, Triangle {
    ...
} 
//子类继承
public final class Rect extends Shape {...} 
//sealed类在Java 15中目前是预览状态，要启用它，必须使用参数--enable-preview和--source 15
-------------------------------------------------------------------------------*/



//3.向上转型，多变少 ，具体变抽象是允许的，可以溯源
/*------------------------------------------------------------------------------- 
如果Student是从Person继承下来的，
那么，一个引用类型为Person的变量，能否指向Student类型的实例？
Person p = new Student(); // ??? 
测试一下，这种指向是没有问题的
向上转型实际上是把一个子类型安全地变为更加抽象的父类型
-------------------------------------------------------------------------------*/



//4.向下转型，少变多是不允许的
/*-------------------------------------------------------------------------------
如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）
Person p2 = new Person();
Student s2 = (Student) p2; // runtime error! ClassCastException!
不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。

为了避免向下转型出错，Java提供了instanceof操作符

Person p = new Student();
if (p instanceof Student) {
    // 只有判断成功才会向下转型:
    Student s = (Student) p; // 一定会成功
}
 */

//5.区分继承和组合
/*-------------------------------------------------------------------------------
Book类也有name字段，那么，我们能不能让Student继承自Book呢？
答案是不能，
Student是Person的一种，它们是is关系，
而Student并不是Book。实际上Student和Book的关系是has关系。
具有has关系不应该使用继承，而是使用组合，即Student可以持有一个Book实例：

class Student extends Person {
    protected Book book;
    protected int score;
}
-------------------------------------------------------------------------------*/


//6.多态
/*-------------------------------------------------------------------------------
class Person {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}
那么，一个实际类型为Student，引用类型为Person的变量，
调用其run()方法，调用的是Person还是Student的run()方法？

运行一下上面的代码就可以知道，实际上调用的方法是Student的run()方法。因此可得出结论：
Java的实例方法调用
是基于运行时的实际类型的动态调用，
而非变量的声明类型

多态具有一个非常强大的功能，就是允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码

-------------------------------------------------------------------------------*/

//重写和重载的区别
/*
重写:
　　 重写（Override）是父类与子类之间多态性的一种表现。
    如果在子类中定义某方法与其父类有相同的名称和参数，
    我们说该方法被重写 (Override)。

　　
重载：
　　 重载（Overload）是一个类中多态性的一种表现。
    如果在一个类中定义了多个同名的方法，它们参数列表不同，
    则称为方法的重载(Overload)

重写的好处在于子类可以根据需要，定义特定于自己的行为。
也就是说子类能够根据需要实现父类的方法。
重写就是我们所说的常规意义上的多态


 */

