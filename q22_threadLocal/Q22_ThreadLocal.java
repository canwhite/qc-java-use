package q22_threadLocal;

public class Q22_ThreadLocal {
    public static void main(String[] args) {
        /*
            这种在一个线程中，横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），
            它是一种状态，可以是用户身份、任务信息等。
            给每个方法增加一个context参数非常麻烦
            Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象
            ThreadLocal一定要在finally中清除,
            当然我们可以调用AutoCloseable接口自动清除
         */


        //在外部定义context
        UserContext ctx = new UserContext("Bob");
        //使用的时候
        try(ctx){
            // 可任意调用UserContext.currentUser():
            String currentUser = UserContext.currentUser();
            System.out.println("user:"+currentUser);
        }
        //在逻辑块结束的时候
        //在此自动调用UserContext.close()方法释放ThreadLocal关联对象


    }
}

class UserContext implements  AutoCloseable{

    //创建一个gloabl的ThreadLocal的对象
    static final  ThreadLocal<String> ctx = new ThreadLocal<>();

    //在构造函数的时候做了set
    public UserContext(String user){
        ctx.set(user);
    }

    //get操作
    public  static  String currentUser(){
        return  ctx.get();
    }

    @Override
    public  void close(){
        ctx.remove();
    }
}





