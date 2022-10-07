package q21_completable_feature;

// import com.sun.tools.javac.Main;

import java.util.concurrent.CompletableFuture;

public class Q21_CompletableFuture {
    //throws Exception的意思是本方法不处理异常，层层往上抛，交给调用方去处理
    public static void main(String[] args)  throws Exception{
        //带有回调函数的feature
        /***
        1 . 基础使用，以获取股票价格为例
        ****/

        //(1)创建异步执行任务,注意这里有一个静态方法的调用语法糖 ::    Q21_CompletableFuture::fetchPrice
        //注意是使用supplyAsync接收的异步方法
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            return  fetchPrice("234872");
        });
        //(2)如果执行成功,注意java和js的区别，箭头是单横箭头
        cf.thenAccept((result)->{
            System.out.println("price: " + result);
        });
        //(3)如果执行失败
        cf.exceptionally((e)->{
            e.printStackTrace();
            return null;
        });


        /***
         *2.连续事件
         * thenApplyAsync
         */
        //第一个任务
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(()->{
            return  queryCode("中国石油");
        });

        //第二个任务，thenApplyAsync , 接着cfQuery
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code)->{
            //valueOf是装包的过程
            return  fetchPrice(code);
        });

        //在第二个任务结束的时候获取回调
        cfFetch.thenAccept((result)->{
            System.out.println("priceQue: " + result);
        });




        /***
         * 并行执行
         * 同时从新浪和网易查询证件代码，
         * 只要任意一个返回结果，就进行下一步查询价格
         * 查询价格也同时从新浪和网易查询，
         * 只要任意一个返回结果，就完成操作
         * anyof
         */

        //两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });

        //用anyof合并两个新的CompletableFuture
        CompletableFuture<Object> cfFetchOf = CompletableFuture.anyOf(cfQueryFromSina,cfQueryFrom163);

        //最终结果
        cfFetchOf.thenAccept((result) -> {
            System.out.println("priceOf: " + result);
        });


        //(4)主线程不要立刻结束，不然cfeature默认使用的线程池会关闭
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //查编码
    static  String queryCode(String name){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        return  "601857";
    }

    //上一级如果是传入字符串，这里要同步
    static Double fetchPrice(String code){
        //模拟一个异步方法
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}

/*
PS:
ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
在这里补充一下ForkJoin
核心代码SumTask继承自RecursiveTask，
在compute()方法中，关键是如何“分裂”出子任务并且提交子任务

class SumTask extends RecursiveTask<Long> {
    protected Long compute() {
        // “分裂”子任务:
        SumTask subtask1 = new SumTask(...);
        SumTask subtask2 = new SumTask(...);

        // invokeAll会并行运行两个子任务:
        invokeAll(subtask1, subtask2);
        // 获得子任务的结果:
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        // 汇总结果:
        return subresult1 + subresult2;
    }
}
Fork/Join线程池在Java标准库中就有应用。
Java标准库提供的java.util.Arrays.parallelSort(array)可以进行并行排序，
它的原理就是内部通过Fork/Join对大数组分拆进行并行排序，在多核CPU上就可以大大提高排序的速度

 */







