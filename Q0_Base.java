//类名习惯以大写开头
public class Q0_Base{
    public static void main(String[] args){
        System.out.println("Hello, world!"); // 语句
        /*
            整数运算 int 
            浮点数运算 float和double
            布尔运算
            字符和字符串
        */
        /*---------------整数-------------------*/ 
        //整数 int
        int i = (100 + 200) * (99 - 88); // 3300
        i++;
        System.out.println(i);
        // 整数移位运算
        int n = 7;       // 00000000 00000000 00000000 00000111 = 7
        int a = n << 1;  // 00000000 00000000 00000000 00001110 = 14
        System.out.println(a);
        // 位运算
        n = 0 & 1; // 0
        System.out.println(n);
        // PS：也可以强制转型 (类型) ，但是超出范围的强制转型会报错
        


        /*---------------浮点数-------------------*/ 
        //浮点数运算和整数运算相比，只能进行加减乘除这些数值计算，不能做位运算和移位运算。

        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x);
        System.out.println(y);
        /* 0.1
        0.09999999999999998 */
        //从上边可以看出，浮点数存在运算误差
        //so：我们可以比较它们的绝对值
        double r = Math.abs(x - y);
        // 再判断绝对值是否足够小:
        if (r < 0.00001) {
            // 可以认为相等
            System.out.println("认为是相等");
        } else {
            // 不相等
            System.out.println("认为是不想等");
        }
        //类型提升 
        //如果参与运算的两个数其中一个是整型，那么整型可以自动提升到浮点型




        /*---------------布尔类型-------------------*/ 
        boolean isGreater = 5 > 3; // true
        System.out.println(isGreater);




        /*---------------字符串-------------------*/ 
        //字符串拼接
        int age = 25;
        //字符串这个有点不同，它的类型定义首字母是大写的
        //说明它是一个引用类型，或者说是一个对象类型
        String s = "age is " + age;
        System.out.println(s);
        
        // 这种类型的字符串要求的版本比较高
        // String s1 = """
        //     SELECT * FROM
        //     users
        //     WHERE id > 100
        //     ORDER BY name DESC """;

        s = "hello world"; //这里s 变了吗？其实没有变，变的不是字符串，而是变量s的“指向”
        System.out.println(s); 

        //引用类型的变量可以指向一个空值null
        /* String s1 = null; // s1是null
        String s2; // 没有赋初值值，s2也是null */

        

        /*---------------包装类-------------------*/ 
        /* 
        
        在Java基本类型里，只有String是大写开头的，
        其实也可以吧它理解为java中的一个包装类，主要是引用类型
        这里我们说一下其他类型的包装类，并且了解一下装包和拆包 */

        /* 
        基本类型	对应的引用类型
        boolean	  java.lang.Boolean
        byte	  java.lang.Byte
        short	  java.lang.Short
        int	      java.lang.Integer
        long	  java.lang.Long
        float	  java.lang.Float
        double	  java.lang.Double
        char	  java.lang.Character 
        */


        //装包和拆包基本举例
        int cargo = 100;
        //用valueOf装包
        Integer pack = Integer.valueOf(cargo);
        //用xxxValue拆包
        int newCargo = pack.intValue();
        System.out.println(newCargo);




    }
}
