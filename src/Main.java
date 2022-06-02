import callThread.MyCallable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> myCallable = new MyCallable();
        Collection<Callable<String>> myCallableList = new ArrayList<>();
        myCallableList.add(myCallable);
        myCallableList.add(myCallable);
        myCallableList.add(myCallable);
        myCallableList.add(myCallable);
        myCallableList.add(myCallable);

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        String resultOfTask = threadPool.invokeAny(myCallableList);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(resultOfTask);

        threadPool.shutdown();

        Callable<String> myCallable2 = new MyCallable();

        ExecutorService threadPool2 = Executors.newFixedThreadPool(4);
        Future<String> task = threadPool2.submit(myCallable2);
        String submitResultOfTask = task.get();

        System.out.println(submitResultOfTask);

        threadPool2.shutdown();
    }
}
