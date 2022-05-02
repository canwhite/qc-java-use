public class Q7_Callback {
    public static void main(String[] args) {
        
        MainBusiness mainBusiness = new MainBusiness();
        //匿名回调,实例化和实现
        mainBusiness.execute(new CallbackService() {
            public void callBackFunc() {
                System.out.println("run start...");
                System.out.println("run end...\n");
            }
        });

    }
}

//接口类
interface CallbackService {
    void callBackFunc();
}

//业务类和方法
class MainBusiness{
    //callback作为组合成员嵌进来
    private CallbackService callback;
    //在执行函数中作为参数
    public void execute(CallbackService callback) {
        this.callback = callback;
        this.callBack();//callback，传进来，在这里执行
    }
 
    public void callBack() {
        this.callback.callBackFunc();
    }
}

