package q27_stream;

// import java.sql.Array;
import java.util.Arrays;
import java.util.List;
// import java.util.Optional;
import java.util.Set;
// import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUse {

    public static void main(String[] args) {


        //一、stream初始化
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        stream.forEach((item)->{
            System.out.println(item);
        });

        /** 
         * list可以直接stream 
         * 而array需要借助于Arrays.stream
        */

        //将list转化为stream,
        List<Integer> list = List.of(1,2,3);
        list.stream().forEach(System.out::println);



        //将array转化为stream
        int[] nums = new int[5];
        Arrays.stream(nums).forEach((item)->{
            System.out.println(item);
        });

    

        //二、使用toArray
        //PS：顺带转化为Array，在转化的时候指定类型,如果不指定类型，得到的是Object[]
        Object[] objArr = list.stream().toArray();
        Arrays.stream(objArr).forEach(System.out::println);


        /**三、collect使用toList*/

        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numList.stream().forEach(System.out::println);


        //四、使用map
        //mapTo[Int | Long | Double]: toArray补充，转化为特定类型的stream
        int[] arr =  list.stream().mapToInt((item)->{
            return Integer.valueOf(item); //返回integer，然后应该是内部做了一层转int
        }).toArray();
        Arrays.stream(arr).forEach(System.out::println);

        //使用map，可以从一种流转化为另外一种流
        Stream<String> strStream =  list.stream().map((item)->{
            return String.valueOf(item);
        });
        strStream.forEach(System.out::println);
        // List<String>  strList = strStream.collect(Collectors.toList());
        // strList.stream().forEach(System.out::println);



        //五、使用filter
        Stream<String> ns =  List.of("1","2","3").stream().filter((item)->{
            return item == "1";
        });
        ns.forEach(item->{
            System.out.println(":"+item);
        });





        //六、使用limit和skip
        /**
         * limit截取前2个
         * skip跳过前2个
         */

        list.stream().limit(2).forEach(item->{
            System.out.println("l:"+item);
        });

        list.stream().skip(2).forEach(item->{
            System.out.println("s:" + item);
        });


        //七、使用min、max和count ，可以在后边搭配
        //执行完min相当于先得到Optional<Integer>，然后get()从Optional里获取Integer，然后再拆包
        var min = list.stream().min(Integer::compareTo).get().intValue();
        System.out.println("min:" +min);

        //当然我们也可以使用array试一下,可以看出来，一开始如果就是int，就很方便
        var minn = Arrays.stream(nums).min().getAsInt();
        System.out.println("minn:" +minn);//先get再转化为intValue
    



        
    }


    
}
