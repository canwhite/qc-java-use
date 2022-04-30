import java.util.StringJoiner;

public class Q1_String {
    public static void main(String[] args) {
        //1.字符串拼接
        //(1)  + 不做过多赘述
        //(2)  使用concat操作
        String info = "三国演义、";
        info = info.concat("西游记、");
        info = info.concat("水浒传、");
        info = info.concat("红楼梦");
        System.out.println(info);

        //(3)StringBuilder ,高效拼接字符串
        //可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象：
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s);


        //(4)这是一种在js经常使用的join，在Java中叫做StringJoiner
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(",");//确定间隔符
        for(String name : names){
            sj.add(name);
        }
        //无论是sb还是sj，最终推出的都不是
        System.out.println("----" +sj.toString());
        


        //2.获取字符串的长度，length方法而不是属性
        String sys = " Cases ";// 字义一个字符串表示系统名称
        System.out.println(sys.length());

        //3.大小写转换
        System.out.println(sys.toLowerCase());
        System.out.println(sys.toUpperCase());


        //4.去掉前后空格
        System.out.println(sys.trim());


        //5.查找索引位置
        String str = "Hello Java";
        int size = str.indexOf('v'); 
        System.out.println(size);


        //6.字符串比较 equals
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "ABC";
        System.out.println(str1.equals(str2)); // 输出 true
        System.out.println(str1.equals(str3)); // 输出 false

        
    }
}
