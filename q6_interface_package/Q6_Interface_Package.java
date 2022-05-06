package  q6_interface_package;
public class Q6_Interface_Package {
    public static void main(String[] args) {
        //interface是在抽象类的基础上进一步发展来的，只定义不实现
        /* 
        //抽象类
        abstract class Person {
            public abstract void run();
        } 
        */
    }
}

interface Person {
    void run();
    String getName();
}

//当一个具体的class去实现一个interface时，需要使用implements关键字。举个例子：
//而且，类只能继承一个，但是接口可以继承多个
class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run");
    }

    @Override
    public String getName() {
        return this.name;
    }
}

/*
package
package是一种命名空间

eg:

小明的Person类存放在包ming下面，因此，完整类名是ming.Person；

小红的Person类存放在包hong下面，因此，完整类名是hong.Person；

小军的Arrays类存放在包mr.jun下面，因此，完整类名是mr.jun.Arrays；

JDK的Arrays类存放在包java.util下面，因此，完整类名是java.util.Arrays。

在定义class的时候，我们需要在第一行声明这个class属于哪个包。

在Java虚拟机执行的时候，JVM只看完整类名，因此，只要包名不同，类就不同。


我们还需要按照包结构把上面的Java文件组织起来。
假设以package_sample作为根目录，src作为源码目录，
那么所有文件结构就是：

package_sample
└─ src
    ├─ hong
    │  └─ Person.java
    │  ming
    │  └─ Person.java
    └─ mr
       └─ jun
          └─ Arrays.java

//eg : 最后一个          
package mr.jun; // 申明包名mr.jun
public class Arrays {
}
即所有Java文件对应的目录层次要和包的层次一致。

package_sample
└─ bin
   ├─ hong
   │  └─ Person.class
   │  ming
   │  └─ Person.class
   └─ mr
      └─ jun
         └─ Arrays.class

编译后的.class文件也需要按照包结构存放。如果使用IDE，
把编译后的.class文件放到bin目录下，那么，编译的文件结构就是：
package_sample
└─ bin
   ├─ hong
   │  └─ Person.class
   │  ming
   │  └─ Person.class
   └─ mr
      └─ jun
         └─ Arrays.class
//以下是编译命令
javac -d ../bin ming/Person.java hong/Person.java mr/jun/Arrays.java
但是现实中使用ide就没有这么复杂

--包作用域
位于同一个包的类，可以访问包作用域的字段和方法。
不用public、protected、private修饰的字段和方法就是包作用域

//总结：这里的包和文件结构对应统一

*/


//引入静态文件 import static java.lang.System.*;